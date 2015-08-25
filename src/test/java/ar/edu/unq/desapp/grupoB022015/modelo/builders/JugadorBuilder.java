package ar.edu.unq.desapp.grupoB022015.modelo.builders;

import ar.edu.unq.desapp.grupoB022015.modelo.Jugador;
import ar.edu.unq.desapp.grupoB022015.modelo.posiciones.Arquero;
import ar.edu.unq.desapp.grupoB022015.modelo.posiciones.Defensor;
import ar.edu.unq.desapp.grupoB022015.modelo.posiciones.Delantero;
import ar.edu.unq.desapp.grupoB022015.modelo.posiciones.Mediocampista;

public class JugadorBuilder{

	private Jugador jugador;
	
	private JugadorBuilder(){
		jugador = new Jugador();
	}
	
	//------------------ Interfaz publica ------------------\\
	
	public static JugadorBuilder algunJugador(){
		return new JugadorBuilder();
	}
		
	public JugadorBuilder arquero(){
		jugador.setPosicion(new Arquero());
		return this;
	}
	
	public JugadorBuilder defensor(){
		jugador.setPosicion(new Defensor());
		return this;
	}
	
	public JugadorBuilder mediocampista(){
		jugador.setPosicion(new Mediocampista());
		return this;
	}
	
	public JugadorBuilder delantero(){
		jugador.setPosicion(new Delantero());
		return this;
	}
	
	
	public Jugador build(){
		return jugador;
	}
	
}
