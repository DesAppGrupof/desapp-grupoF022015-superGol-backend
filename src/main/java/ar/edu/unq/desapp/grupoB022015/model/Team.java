package ar.edu.unq.desapp.grupoB022015.model;

import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.CantAddPlayerException;

public class Team {

	//---------------------- Private ----------------------\\
	
	private Players	players;
		
	//------------------- Public interface -------------------\\
	
	public Team(){
		players = new Players();
	}
	
	public void addPlayer(Player aPlayer) throws CantAddPlayerException {
		players.addPlayer(aPlayer);
	}
	
	public void removePlayer(Player aPlayer){
		players.removePlayer(aPlayer);
	}

	public List<Player> allPlayers() {
		return players.all();
	}

}
