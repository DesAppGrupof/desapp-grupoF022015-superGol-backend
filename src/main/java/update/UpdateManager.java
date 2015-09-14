package update;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.Id;
import ar.edu.unq.desapp.grupoB022015.model.Team;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.InvalidPositionForPlayerWithIdException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.InvalidUpdateDataException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.NoPlayerWithIdException;
import ar.edu.unq.desapp.grupoB022015.model.positions.Position;
import persistence.PlayerHome;
import persistence.TeamHome;
import update.csvReaders.UpdateCSVReader;

public class UpdateManager {

	//---------------------- Private ----------------------\\
	
	private static UpdateManager instance;
	private Integer nextUpdate;
	private List<ProtoPlayer> checkedPlayers;
	
	
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
	
	//------------------- Public interface -------------------\\

	public List<Update> updates;
	public Update newUpdate;
	
	public static UpdateManager getInstance(){
		if(instance == null)
			instance = new UpdateManager();
		return instance;
	}
	
	public void addUncheckedPlayer(Id id, Position position, Integer goals) throws InvalidUpdateDataException {
		checkInfo(id,position);
		
		checkedPlayers.add(new ProtoPlayer(id,goals));
	}
	
	public void update(){
		resetTeamsRoundPoints();
		
		new UpdateCSVReader(nextUpdate).readFile();
		nextUpdate++;
				
		updateRoundGoalsForAllPlayers();
		
		updates.add(newUpdate);
	}

	public void cancelUpdate(Integer version) {
		
	}
	
}
