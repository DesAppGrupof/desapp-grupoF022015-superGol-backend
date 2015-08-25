package ar.edu.unq.desapp.grupoB022015.modelo;

import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.modelo.builders.EquipoBuilder;
import ar.edu.unq.desapp.grupoB022015.modelo.builders.JugadorBuilder;
import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoPuedeHaberMasDeCuatroMediocampistasException;
import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoPuedeHaberMasDeTresDefensoresException;
import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoPuedeHaberMasDeTresDelanterosException;
import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoPuedeHaberMasDeUnArqueroException;
import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoSePuedeHaberMasDeOnceJugadoresException;
import ar.edu.unq.desapp.grupoB022015.modelo.posiciones.Arquero;
import junit.framework.TestCase;

public class TestEquipo extends TestCase{

		
	@Test
	public void test_todosLosJugadores_retornaATodosLosJugadoresDelEquipo(){
		Equipo equipo = EquipoBuilder.algunEquipo().conPlantelCompleto().build();
		
		assertEquals(equipo.todosLosJugadores().size(), 11);
	}
	
	@Test
	public void test_intentarAgregarMasDe11Jugadores_throwNoSePuedeHaberMasDeOnceJugadoresException(){
		Equipo equipo = EquipoBuilder.algunEquipo().conPlantelCompleto().build();
		
		try{
			equipo.agregarJugador(JugadorBuilder.algunJugador().build()); // en esta operacion tira la excepcion
			fail();
		}catch(NoSePuedeHaberMasDeOnceJugadoresException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void test_intentarAgregarMasDeUnArquero_throwsNoPuedeHaberMasDeUnArqueroException(){
		Equipo equipo = EquipoBuilder.algunEquipo().conXArqueros(1).build();	
		try {
			equipo.agregarJugador(JugadorBuilder.algunArquero().build());			
			fail();
		} catch (NoSePuedeHaberMasDeOnceJugadoresException e) {
			fail();
		} catch (NoPuedeHaberMasDeUnArqueroException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void test_intentarAgregarMasDeTresDefensores_throwsNoPuedeHaberMasDeTresDefensoresException(){
		Equipo equipo = EquipoBuilder.algunEquipo().conXDefensores(3).build();	
		try {
			equipo.agregarJugador(JugadorBuilder.algunDefensor().build());			
			fail();
		} catch (NoSePuedeHaberMasDeOnceJugadoresException e) {
			fail();
		} catch (NoPuedeHaberMasDeTresDefensoresException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void test_intentarAgregarMasDeCuatroMediocampistas_throwsNoPuedeHaberMasDeCuatroMediocampistasException(){
		Equipo equipo = EquipoBuilder.algunEquipo().conXMediocampistas(4).build();	
		try {
			equipo.agregarJugador(JugadorBuilder.algunMediocampista().build());			
			fail();
		} catch (NoSePuedeHaberMasDeOnceJugadoresException e) {
			fail();
		} catch (NoPuedeHaberMasDeCuatroMediocampistasException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void test_intentarAgregarMasDeTresDelanteros_throwsNoPuedeHaberMasDeTresDelanterosException(){
		Equipo equipo = EquipoBuilder.algunEquipo().conXDelanteros(3).build();	
		try {
			equipo.agregarJugador(JugadorBuilder.algunDelantero().build());			
			fail();
		} catch (NoSePuedeHaberMasDeOnceJugadoresException e) {
			fail();
		} catch (NoPuedeHaberMasDeTresDelanterosException e) {
			assertTrue(true);
		}
	}
	
}
