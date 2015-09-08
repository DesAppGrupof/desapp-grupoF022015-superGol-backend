package ar.edu.unq.desapp.grupoB022015.model.positions;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanThreeForwardsException;

public class Forward extends Position {
	
	//---------------------- Private ----------------------\\
	

	//------------------- Public interface -------------------\\
	
	public Forward(){
		maxPlayersByTeam = 3;
		goalsRatio = 1;
	}

	@Override
	public void throwCantAddPlayerException() throws NotAllowedMoreThanThreeForwardsException {
		throw new NotAllowedMoreThanThreeForwardsException();
	}
}
