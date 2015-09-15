package ar.edu.unq.desapp.grupoB022015.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.CantAddPlayerException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanElevenPlayersException;
import ar.edu.unq.desapp.grupoB022015.model.positions.Position;

public class Players {

	//---------------------- Private ----------------------\\
	
	private List<Player> players;
	
	private List<String> fileIdsUpdated = new ArrayList<>();
	private List<Date> fileDateUpdated = new ArrayList<>();
	
	private void verifyIfCanAddPlayerWithPosition(Position searchedPosition) throws CantAddPlayerException {
		if(players.size() == 11)
			throw new NotAllowedMoreThanElevenPlayersException();
		
		Integer samePositionPlayers = 0;
		for(Player anyPlayer: players){
			if(anyPlayer.hasPosition(searchedPosition))
				samePositionPlayers++;
		}
		if (samePositionPlayers == searchedPosition.getMaxPlayersByTeam())
			searchedPosition.throwCantAddPlayerException();
	}
	
	//------------------- Public interface -------------------\\
	
	public Players(){
		players = new ArrayList<Player>();
	}
	
	public void addPlayer(Player aPlayer) throws CantAddPlayerException {
		verifyIfCanAddPlayerWithPosition(aPlayer.getPosition());
		players.add(aPlayer);
	}
	
	public void removePlayer(Player aPlayer){
		players.remove(aPlayer);
	}

	public List<Player> all() {
		return players;
	}
	
	public Player findById(int id) {
		Player p =  null;
		for (Player player : all()) {
			if (player.id().number() == id) {
				p = player;
				break;
			}
		}
		return p;
	}
	
	public boolean canUploadRound(File file) {
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String id = br.readLine();
			if (fileIdsUpdated.contains(id)) {
				return false;
			}
		    for(String line; (line = br.readLine()) != null; ) {
		        checkPlayerLine(line);
			}
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public void uploadRound(File file) throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String id = br.readLine();
		    for(String line; (line = br.readLine()) != null; ) {
		        uploadPlayerLine(line);
		    }
			fileIdsUpdated.add(id);
		    fileDateUpdated.add(new Date());
		}
	}
	
	public String[] getLineFields(String line) {
		return line.split(",");
	}
	
	public int getLineId(String[] lineFields) {
		return Integer.parseInt(lineFields[0]);
	}
	
	public int getLineGoals(String[] lineFields) {
		return Integer.parseInt(lineFields[2]);
	}
	
	public String getLinePosition(String[] lineFields) {
		return lineFields[1];
	}
	
	protected boolean checkPlayerLine(String line) {
		boolean canAddPlayer = true;
		String[] fields = getLineFields(line);
		Player player = findById(getLineId(fields));
		if (player == null || !player.getPosition().isPosition(getLinePosition(fields))) {
			canAddPlayer = false;
		}
		return canAddPlayer;
	}
	
	protected void uploadPlayerLine(String line) {
		String fields[] = getLineFields(line);
		Player player = findById(getLineId(fields));
		player.setGoalsInLastRound(getLineGoals(fields));
	}
	
	public List<String> getfileIdsUpdated() {
		return fileIdsUpdated;
	}
}
