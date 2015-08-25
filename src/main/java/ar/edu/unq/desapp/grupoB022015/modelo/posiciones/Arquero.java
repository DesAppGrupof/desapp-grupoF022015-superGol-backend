package ar.edu.unq.desapp.grupoB022015.modelo.posiciones;

import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoPuedeHaberMasDeUnArqueroException;

public class Arquero extends Posicion{
	
	public Arquero(){
		cantidadMaximaPorPlantel = 1;
	}

	@Override
	public void lanzarExcepcionNoPuedeAgregar() throws NoPuedeHaberMasDeUnArqueroException {
		throw new NoPuedeHaberMasDeUnArqueroException();
	}
}
