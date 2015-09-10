package ar.edu.unq.desapp.grupoB022015.model;

import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.CantAddPlayerException;

public class Team extends Persistible{

	//---------------------- Private ----------------------\\
	
	private Players	players;
	private Integer roundPoints = 0;
		
	//------------------- Public interface -------------------\\
	
	public Team(){
		players = new Players();
	}
	
	public void addPlayer(Player aPlayer) throws CantAddPlayerException {
		players.addPlayer(aPlayer);
		aPlayer.addTeam(this);
	}
	
	public void removePlayer(Player aPlayer){
		players.removePlayer(aPlayer);
	}

	public List<Player> allPlayers() {
		return players.all();
	}
	
	public void addPlayerPoints(Integer points){
		roundPoints = roundPoints + points;
	}
	
	public void resetRoundPoints(){
		roundPoints = 0;
	}

}
