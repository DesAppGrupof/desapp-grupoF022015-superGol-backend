package ar.edu.unq.desapp.grupoB022015.modelo.posiciones;

import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoPuedeHaberMasDeCuatroMediocampistasException;

public class Mediocampista extends Posicion {
	
	public Mediocampista(){
		cantidadMaximaPorPlantel = 4;
	}

	@Override
	public void lanzarExcepcionNoPuedeAgregar() throws NoPuedeHaberMasDeCuatroMediocampistasException {
		throw new NoPuedeHaberMasDeCuatroMediocampistasException();
	}
}
