package ar.edu.unq.desapp.grupoB022015.model.exceptions;

import ar.edu.unq.desapp.grupoB022015.model.Id;

public class NoPlayerWithIdException extends InvalidUpdateDataException {

	
	public NoPlayerWithIdException(Id id) {
		message = "No player with id = " + id.number();
	}

}
