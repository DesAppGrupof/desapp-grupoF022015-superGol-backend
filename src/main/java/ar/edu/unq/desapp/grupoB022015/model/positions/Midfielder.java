package ar.edu.unq.desapp.grupoB022015.model.positions;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanFourMidfieldersException;

public class Midfielder extends Position {
	
	//---------------------- Private ----------------------\\
	

	//------------------- Public interface -------------------\\
	
	public Midfielder(){
		maxPlayersByTeam = 4;
	}

	@Override
	public void throwCantAddPlayerException() throws NotAllowedMoreThanFourMidfieldersException {
		throw new NotAllowedMoreThanFourMidfieldersException();
	}
}
