package ar.edu.unq.desapp.grupoB022015.modelo;

import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.modelo.builders.JugadorBuilder;
import ar.edu.unq.desapp.grupoB022015.modelo.posiciones.Arquero;
import ar.edu.unq.desapp.grupoB022015.modelo.posiciones.Defensor;
import ar.edu.unq.desapp.grupoB022015.modelo.posiciones.Delantero;
import ar.edu.unq.desapp.grupoB022015.modelo.posiciones.Mediocampista;
import junit.framework.TestCase;

public class TestJugador extends TestCase{
	
	@Test
	public void test_unJugadorTieneUnaPosicion(){
		Jugador arquero = JugadorBuilder.algunJugador().arquero().build();
		assertEquals(arquero.getPosicion(), new Arquero());
	}
	
	@Test
	public void test_cuandoLePreguntoAUnJugadorSiTieneLaPosicionQueTieneActualmente_RetornaTrue(){
		
		Jugador arquero = JugadorBuilder.algunJugador().arquero().build();
		assertTrue(arquero.tienePosicion(new Arquero()));
		
		Jugador defensor = JugadorBuilder.algunJugador().defensor().build();
		assertTrue(defensor.tienePosicion(new Defensor()));
		
		Jugador mediocampista = JugadorBuilder.algunJugador().mediocampista().build();
		assertTrue(mediocampista.tienePosicion(new Mediocampista()));
		
		Jugador delantero = JugadorBuilder.algunJugador().delantero().build();
		assertTrue(delantero.tienePosicion(new Delantero()));
	}
}
