package ar.edu.unq.desapp.grupoB022015.modelo.posiciones;

import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoPuedeHaberMasDeTresDefensoresException;

public class Defensor extends Posicion {

	public Defensor(){
		cantidadMaximaPorPlantel = 3;
	}

	@Override
	public void lanzarExcepcionNoPuedeAgregar() throws NoPuedeHaberMasDeTresDefensoresException {
		throw new NoPuedeHaberMasDeTresDefensoresException();
	}
}
