package ar.edu.unq.desapp.grupoB022015.modelo.posiciones;

import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoSePuedeAgregarJugadorException;

public abstract class Posicion {
	
	protected int cantidadMaximaPorPlantel;	

	public int getCantidadMaximaPorPlantel() {
		return cantidadMaximaPorPlantel;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	public abstract void lanzarExcepcionNoPuedeAgregar()  throws NoSePuedeAgregarJugadorException;	
	
}
