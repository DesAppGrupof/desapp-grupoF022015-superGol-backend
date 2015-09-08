package ar.edu.unq.desapp.grupoB022015.model.exceptions;

import ar.edu.unq.desapp.grupoB022015.model.Id;

public class InvalidPositionForPlayerWithIdException extends InvalidUpdateDataException {

	public InvalidPositionForPlayerWithIdException(String position, Id id) {
		message = "Player with id = " + id.number() + " isn't a " + position;
	}

}
