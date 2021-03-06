package upload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.Id;
import ar.edu.unq.desapp.grupoB022015.model.Team;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.CanceledUpdate;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.InvalidPositionForPlayerWithIdException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.InvalidUpdateDataException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.NoPlayerWithIdException;
import ar.edu.unq.desapp.grupoB022015.model.positions.Position;
import persistence.PlayerHome;
import persistence.TeamHome;
import upload.csvReaders.UpdateCSVReader;

public class UpdateManager {

	//---------------------- Private ----------------------\\
	
	private static UpdateManager instance;
	private Integer nextUpdate;
	private List<ProtoPlayer> checkedPlayers;
	private boolean continueUpdate = true;
	public Update newUpdate;	
	public List<Update> updates;	
	
	private UpdateManager(){
		nextUpdate = 0;
		checkedPlayers = new ArrayList<ProtoPlayer>();
		updates = new ArrayList<Update>();
	}

	private void checkInfo(Id id, Position position) throws InvalidUpdateDataException {		
		if (!PlayerHome.getInstance().existIdentifier(id))
			throw new NoPlayerWithIdException(id);
		if (!PlayerHome.getInstance().get(id).getPosition().equals(position)){	
			throw new InvalidPositionForPlayerWithIdException(position, id);
		}
	}
	
	private void resetTeamsRoundPoints(){
		for(Team t : TeamHome.getInstance().all()){
			t.resetRoundPoints();
		}
	}
	
	private void updateRoundGoalsForAllPlayers() {
		for(ProtoPlayer pp : checkedPlayers){
			pp.updateReferencedPlayer();
		}
		
		checkedPlayers.clear();
	}
	
	private void preUpdateActions() {
		resetTeamsRoundPoints();
		continueUpdate = true;
		nextUpdate++;
	}
	
	//------------------- Public interface -------------------\\

	
	public static UpdateManager getInstance(){
		if(instance == null)
			instance = new UpdateManager();
		return instance;
	}
	
	public void update() throws IOException, CanceledUpdate{
		preUpdateActions();		
		new UpdateCSVReader(nextUpdate).readFile();	
		if(!continueUpdate) throw new CanceledUpdate();
		updateRoundGoalsForAllPlayers();		
		updates.add(newUpdate);
	}
	
	public void setNewUpdate(Update newestUpdate){
		newUpdate = newestUpdate;
	}
	
	public void addUncheckedPlayer(Id id, Position position, Integer goals) throws InvalidUpdateDataException {
		checkInfo(id,position);		
		checkedPlayers.add(new ProtoPlayer(id,goals));
	}

	public void cancelUpdate() {
		continueUpdate = false;
		nextUpdate--;
	}

	public boolean continueUpdate() {
		return continueUpdate;
	}
	
	public List<Update> updates(){
		return updates;
	}
	
}
