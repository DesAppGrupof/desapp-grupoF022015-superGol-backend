package ar.edu.unq.desapp.grupoB022015.model;

public final class Id {
	
	private Integer number;

	public Id(Integer aNumber){
		number = aNumber;
	}
	
	//------------------- Equals -------------------\\
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Id other = (Id) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	public Integer number() {
		return number;
	}	
}
