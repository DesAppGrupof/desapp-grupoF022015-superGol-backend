package ar.edu.unq.desapp.grupoB022015.model.positions;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.CantAddPlayerException;

public abstract class Position {

	//---------------------- Private ----------------------\\
	
	protected int maxPlayersByTeam;	

	//------------------- Public interface -------------------\\
	
	public int getMaxPlayersByTeam() {
		return maxPlayersByTeam;
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
