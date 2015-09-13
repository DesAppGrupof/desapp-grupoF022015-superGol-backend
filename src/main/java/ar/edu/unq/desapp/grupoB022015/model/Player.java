package ar.edu.unq.desapp.grupoB022015.model;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.positions.Position;

public class Player extends Persistible{

	//---------------------- Private ----------------------\\
	
	private String name;
	private Position position;
	private List<Team> teams = new ArrayList<Team>();
	private Integer goalsInRound = 0;
	
	private void updateTeams(){
		for(Team t : teams)
			t.addPlayerPoints(position.pointsFor(goalsInRound));
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
	
	public Integer getGoalsInRound() {
		return goalsInRound;
	}

	public void setGoalsInRound(Integer goalsInRound) {
		this.goalsInRound = goalsInRound;
		updateTeams();
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void addTeam(Team aTeam){
		teams.add(aTeam);
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
