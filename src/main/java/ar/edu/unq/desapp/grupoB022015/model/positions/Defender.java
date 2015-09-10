package ar.edu.unq.desapp.grupoB022015.model.positions;

import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanThreeDefendersException;

public class Defender extends Position {

	//---------------------- Private ----------------------\\
	
	
	//------------------- Public interface -------------------\\

	public Defender(){
		maxPlayersByTeam = 3;
		goalsRatio = 3;
	}

	@Override
	public void throwCantAddPlayerException() throws NotAllowedMoreThanThreeDefendersException {
		throw new NotAllowedMoreThanThreeDefendersException();
	}


}
