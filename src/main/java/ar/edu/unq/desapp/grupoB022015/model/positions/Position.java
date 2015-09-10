package ar.edu.unq.desapp.grupoB022015.model.positions;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.CantAddPlayerException;

public abstract class Position {

	//---------------------- Private ----------------------\\
	
	protected Integer maxPlayersByTeam;	
	protected Integer goalsRatio;

	//------------------- Public static interface -------------------\\

	public static Position instance(String position) {
		Position needed = null;
		if (position.toLowerCase() == "goalkeeper")
			needed = new GoalKeeper();
		if (position.toLowerCase() == "defender")
			needed = new Defender();
		if (position.toLowerCase() == "midfielder")
			needed = new Midfielder();
		if (position.toLowerCase() == "forward")
			needed = new Forward();
			
		return needed;
	}
	
	//------------------- Public interface -------------------\\
	
	public int getMaxPlayersByTeam() {
		return maxPlayersByTeam;
	}

	public Integer pointsFor(Integer goals){
		return goals * goalsRatio;
	}
	
	
	public abstract void throwCantAddPlayerException()  throws CantAddPlayerException;	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
