package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.positions.Position;

public class Player extends Persistible{

	//---------------------- Private ----------------------\\
	
	private String name;
	private Position position;
	private List<Team> teams = new ArrayList<Team>();
	private Integer goalsInLastRound = 0;
	private List<Integer> pointsByRound = new ArrayList<Integer>();
	
	private void updateTeams(){
		for(Team t : teams)
			t.addPlayerPoints(pointsByRound.get(pointsByRound.size() - 1));
	}
	
	//------------------- Public interface -------------------\\

	public String getName(){
		return name;
	}
	
	public void setName(String aName){
		name = aName;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public boolean hasPosition(Position unaPosition) {
		return position.equals(unaPosition);
	}
	
	public Integer getGoalsInLastRound() {
		return goalsInLastRound;
	}

	public void setGoalsInLastRound(Integer goalsInRound) {
		this.goalsInLastRound = goalsInRound;
		this.pointsByRound.add(position.pointsFor(goalsInLastRound));
		updateTeams();
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void addTeam(Team aTeam){
		teams.add(aTeam);
	}
	
	public Integer pointsInSeason(){
		Integer pointsInSeason = 0;
		for(Integer points : pointsByRound){
			pointsInSeason = pointsInSeason + points;
		}
		return pointsInSeason;
	}
	
	
	//------------------- Equals -------------------\\
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
