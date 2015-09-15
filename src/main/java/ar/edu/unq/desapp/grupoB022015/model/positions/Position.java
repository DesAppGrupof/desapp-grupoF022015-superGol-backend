package ar.edu.unq.desapp.grupoB022015.model.positions;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.CantAddPlayerException;

public abstract class Position {

	//---------------------- Private ----------------------\\
	
	protected Integer maxPlayersByTeam;	
	protected Integer goalsRatio;

	public static Position getPositionWithName(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return (Position) Class.forName("ar.edu.unq.desapp.grupoB022015.model.positions."+ name).newInstance();
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
