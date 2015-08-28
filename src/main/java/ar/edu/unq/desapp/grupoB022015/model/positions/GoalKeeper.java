package ar.edu.unq.desapp.grupoB022015.model.positions;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanOneGoalkeeperException;

public class GoalKeeper extends Position{
	
	//---------------------- Private ----------------------\\
	

	//------------------- Public interface -------------------\\
		
	public GoalKeeper(){
		maxPlayersByTeam = 1;
	}

	@Override
	public void throwCantAddPlayerException() throws NotAllowedMoreThanOneGoalkeeperException {
		throw new NotAllowedMoreThanOneGoalkeeperException();
	}
}
