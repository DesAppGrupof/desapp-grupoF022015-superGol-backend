package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.CantAddPlayerException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanElevenPlayersException;
import ar.edu.unq.desapp.grupoB022015.model.positions.Position;

public class Players {

	//---------------------- Private ----------------------\\
	
	private List<Player> players;
	
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
	
	public boolean contains(Player player) {
		return players.contains(player);
	}

}
