package ar.edu.unq.desapp.grupoB022015.model;

import ar.edu.unq.desapp.grupoB022015.model.positions.Position;

public class Player extends Persistible{

	//---------------------- Private ----------------------\\
	
	private Position position;
	
	//------------------- Public interface -------------------\\

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public boolean hasPosition(Position unaPosition) {
		return position.equals(unaPosition);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
