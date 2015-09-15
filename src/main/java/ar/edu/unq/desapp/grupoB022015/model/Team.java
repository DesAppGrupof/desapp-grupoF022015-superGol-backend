package ar.edu.unq.desapp.grupoB022015.model;

import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.CantAddPlayerException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.CaptainMustBeATeamsPlayerException;

public class Team extends Persistible{

	//---------------------- Private ----------------------\\
	
	private Bench	bench;
	private Integer roundPoints = 0;
	private Player captain;	
	
	public void setPlayers(Bench bench) {
		this.bench = bench;
	}
	
	//------------------- Public interface -------------------\\

	public Team(){
		bench = new Bench();
	}
	
	public Player getCaptain() {
		return captain;
	}

	public void setCaptain(Player newCaptain) throws CaptainMustBeATeamsPlayerException  {
		if (!bench.contains(newCaptain))
			throw new CaptainMustBeATeamsPlayerException();
		this.captain = newCaptain;
	}
	
	public void addPlayer(Player aPlayer) throws CantAddPlayerException {
		bench.addPlayer(aPlayer);
		aPlayer.addTeam(this);
	}
	
	public void removePlayer(Player aPlayer){
		bench.removePlayer(aPlayer);
	}

	public List<Player> allPlayers() {
		return bench.all();
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
