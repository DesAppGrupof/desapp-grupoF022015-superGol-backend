package ar.edu.unq.desapp.grupoB022015.model.exceptions;

import ar.edu.unq.desapp.grupoB022015.model.Id;
import ar.edu.unq.desapp.grupoB022015.model.positions.Position;

public class InvalidPositionForPlayerWithIdException extends InvalidUpdateDataException {

	public InvalidPositionForPlayerWithIdException(Position position, Id id) {
		message = "Player with id = " + id.number() + " isn't a " + position.toString();
	}

}
