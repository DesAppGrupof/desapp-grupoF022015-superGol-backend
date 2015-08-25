package ar.edu.unq.desapp.grupoB022015.modelo.builders;

import ar.edu.unq.desapp.grupoB022015.modelo.Equipo;
import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoSePuedeAgregarJugadorException;

public class EquipoBuilder {
	private Equipo equipo;
	
	private EquipoBuilder(){
		equipo = new Equipo();
	}
	
	public static EquipoBuilder algunEquipo(){
		EquipoBuilder instance = new EquipoBuilder();
		return instance;
	}
	
	public Equipo build(){
		return equipo;
	}

	public EquipoBuilder conXArqueros(int cant) {
		for(int i = 0; i < cant; i++){
			try {
				equipo.agregarJugador(JugadorBuilder.algunJugador().arquero().build());
			} catch (NoSePuedeAgregarJugadorException e) {
				e.printStackTrace();
			}
		}
		return this;
	}
	
	public EquipoBuilder conXDefensores(int cant) {
		for(int i = 0; i < cant; i++){
			try {
				equipo.agregarJugador(JugadorBuilder.algunJugador().defensor().build());
			} catch (NoSePuedeAgregarJugadorException e) {
				e.printStackTrace();
			}
		}
		return this;
	}
	
	public EquipoBuilder conXMediocampistas(int cant) {
		for(int i = 0; i < cant; i++){
			try {
				equipo.agregarJugador(JugadorBuilder.algunJugador().mediocampista().build());
			} catch (NoSePuedeAgregarJugadorException e) {
				e.printStackTrace();
			}
		}
		return this;
	}
	
	public EquipoBuilder conXDelanteros(int cant) {
		for(int i = 0; i < cant; i++){
			try {
				equipo.agregarJugador(JugadorBuilder.algunJugador().delantero().build());
			} catch (NoSePuedeAgregarJugadorException e) {
				e.printStackTrace();
			}
		}
		return this;
	}

	public EquipoBuilder conPlantelCompleto() {
		return this.conXArqueros(1).conXDefensores(3).conXMediocampistas(4).conXDelanteros(3);
	}
}
