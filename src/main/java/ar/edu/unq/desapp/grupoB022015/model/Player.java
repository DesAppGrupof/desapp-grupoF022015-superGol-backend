package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.positions.Position;

public class Player extends Persistible{

	//---------------------- Private ----------------------\\
	
	private String name;
	private Position position;
	private List<Team> teams = new ArrayList<Team>();
	private List<Integer> pointsByRound = new ArrayList<Integer>();
	private String realteam;
	
	private void updateTeams(){
		for(Team t : teams)
			t.addPlayerPoints(pointsByRound.get(pointsByRound.size() - 1));
	}
	
	private Integer totalMatchPlayed(){
		return pointsByRound.size();
	}
	
	//------------------- Public interface -------------------\\
	public boolean hasPosition(Position unaPosition) {
		return position.equals(unaPosition);
	}

	public void setGoalsInLastRound(Integer goalsInRound) {
		this.pointsByRound.add(position.pointsFor(goalsInRound));
		updateTeams();
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
	
	public Integer pointsInLastThreeRounds(){
		Integer points = 0;
		if(pointsByRound.size() >= 3)
			points = pointsByRound.get(pointsByRound.size() -1) + 
					 pointsByRound.get(pointsByRound.size() -2)	+
					 pointsByRound.get(pointsByRound.size() -3);
		if(pointsByRound.size() == 2)
			points = pointsByRound.get(1) + pointsByRound.get(0);
		if(pointsByRound.size() == 1)
			points = pointsByRound.get(0);
		return points;
	}
	
	public Double averagePointsForRound(){
		return (double) (pointsInSeason() / totalMatchPlayed());
	}	

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

	public List<Team> getTeams() {
		return teams;
	}

	public void setRealTeam(String team) {
		realteam = team;
	}	
		
	public String getRealTeam() {
		return realteam;
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
