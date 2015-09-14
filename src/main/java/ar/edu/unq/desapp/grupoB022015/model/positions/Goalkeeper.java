package ar.edu.unq.desapp.grupoB022015.model.positions;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanOneGoalkeeperException;

public class Goalkeeper extends Position{
	
	//---------------------- Private ----------------------\\
	
	
	//------------------- Public interface -------------------\\
		
	public Goalkeeper(){
		maxPlayersByTeam = 1;
	}

	@Override
	public Integer pointsFor(Integer goals){
		if (goals == 0)
			return 3;
		else
			return 0;
	}
	
	@Override
	public void throwCantAddPlayerException() throws NotAllowedMoreThanOneGoalkeeperException {
		throw new NotAllowedMoreThanOneGoalkeeperException();
	}
}
