package ar.edu.unq.desapp.grupoB022015.modelo.posiciones;

import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoPuedeHaberMasDeTresDelanterosException;

public class Delantero extends Posicion {
	
	public Delantero(){
		cantidadMaximaPorPlantel = 3;
	}

	@Override
	public void lanzarExcepcionNoPuedeAgregar() throws NoPuedeHaberMasDeTresDelanterosException {
		throw new NoPuedeHaberMasDeTresDelanterosException();
	}
}
