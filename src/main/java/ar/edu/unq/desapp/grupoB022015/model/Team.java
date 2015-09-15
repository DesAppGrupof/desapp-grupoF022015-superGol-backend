package ar.edu.unq.desapp.grupoB022015.model;

import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.CantAddPlayerException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.CaptainMustBeATeamsPlayerException;

public class Team extends Persistible{

	//---------------------- Private ----------------------\\
	
	private Players	players;
	private Integer roundPoints = 0;
	private Player captain;	
	
	public void setPlayers(Players players) {
		this.players = players;
	}
	
	//------------------- Public interface -------------------\\

	public Team(){
		players = new Players();
	}
	
	public Player getCaptain() {
		return captain;
	}

	public void setCaptain(Player newCaptain) throws CaptainMustBeATeamsPlayerException  {
		if (!players.contains(newCaptain))
			throw new CaptainMustBeATeamsPlayerException();
		this.captain = newCaptain;
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
	
	public Integer getRoundPoints() {
		return roundPoints;
	}

	public void resetRoundPoints(){
		roundPoints = 0;
	}

}
