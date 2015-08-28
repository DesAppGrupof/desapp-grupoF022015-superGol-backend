package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.CantAddPlayerException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanElevenPlayersException;
import ar.edu.unq.desapp.grupoB022015.model.positions.Position;

public class Players {

	//---------------------- Private ----------------------\\
	
	private List<Player> players;
	
	private void verifyIfCanAddPlayerWithThisPosition_And_ThrowExceptionIfNot(Position searchedPosition) throws CantAddPlayerException {
		if(players.size() == 11)
			throw new NotAllowedMoreThanElevenPlayersException();
		
		Integer cantSamePositionPlayers = 0;
		for(Player anyPlayer: players){
			if(anyPlayer.hasPosition(searchedPosition))
				cantSamePositionPlayers++;
		}
		if (cantSamePositionPlayers == searchedPosition.getMaxPlayersByTeam())
			searchedPosition.throwCantAddPlayerException();
	}
	
	//------------------- Public interface -------------------\\
	
	public Players(){
		players = new ArrayList<Player>();
	}
	
	public void addPlayer(Player aPlayer) throws CantAddPlayerException {
		verifyIfCanAddPlayerWithThisPosition_And_ThrowExceptionIfNot(aPlayer.getPosition());
		players.add(aPlayer);
	}
	
	public void removePlayer(Player aPlayer){
		players.remove(aPlayer);
	}

	public List<Player> all() {
		return players;
	}
}
