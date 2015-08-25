package ar.edu.unq.desapp.grupoB022015.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoSePuedeAgregarJugadorException;
import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoSePuedeHaberMasDeOnceJugadoresException;
import ar.edu.unq.desapp.grupoB022015.modelo.posiciones.Posicion;

public class ChequeadorPlantel {

	public static void chequearQuePuedeAgregar(Posicion posicionBuscada, List<Jugador> plantel) throws NoSePuedeAgregarJugadorException {
		if(plantel.size() == 11)
			throw new NoSePuedeHaberMasDeOnceJugadoresException();
		List<Jugador> jugadoresDeLaMismaPosicion = new ArrayList<Jugador>();
		for(Jugador j: plantel){
			if(j.tienePosicion(posicionBuscada))
				jugadoresDeLaMismaPosicion.add(j);
		}
		if (jugadoresDeLaMismaPosicion.size() == posicionBuscada.getCantidadMaximaPorPlantel())
			posicionBuscada.lanzarExcepcionNoPuedeAgregar();
	}

}
