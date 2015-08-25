package ar.edu.unq.desapp.grupoB022015.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoSePuedeAgregarJugadorException;

public class Equipo {

	private List<Jugador> plantel;
	
	
	
	//------------------ Interfaz publica ------------------\\
	
	public Equipo(){
		plantel = new ArrayList<Jugador>();
	}
	
	public void agregarJugador(Jugador unJugador) throws NoSePuedeAgregarJugadorException {
		ChequeadorPlantel.chequearQuePuedeAgregar(unJugador.getPosicion(), plantel);
		plantel.add(unJugador);
	}

	public List<Jugador> todosLosJugadores() {
		return plantel;
	}

}
