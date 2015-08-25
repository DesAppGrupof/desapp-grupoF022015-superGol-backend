package ar.edu.unq.desapp.grupoB022015.modelo;

import ar.edu.unq.desapp.grupoB022015.modelo.posiciones.Posicion;

public class Jugador {
	
	private Posicion posicion;

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public boolean tienePosicion(Posicion unaPosicion) {
		return posicion.equals(unaPosicion);
	}
	
}
