package ar.edu.unq.desapp.grupoB022015.model;

import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.model.positions.Defender;
import ar.edu.unq.desapp.grupoB022015.model.positions.Forward;
import ar.edu.unq.desapp.grupoB022015.model.positions.Goalkeeper;
import ar.edu.unq.desapp.grupoB022015.model.positions.Midfielder;
import ar.edu.unq.desapp.grupoB022015.model.positions.Position;
import junit.framework.TestCase;

public class PositionTest extends TestCase{

	@Test
	public void test_Goalkeeper_pointsFor_0_Goals(){
		Goalkeeper goalkeeper = new Goalkeeper();
		
		assertTrue(goalkeeper.pointsFor(0) == 2);
	}
	
	@Test
	public void test_Goalkeeper_pointsFor_1_Goal(){
		Goalkeeper goalkeeper = new Goalkeeper();
		
		assertTrue(goalkeeper.pointsFor(1) == 0);
	}
	
	@Test
	public void test_Defender_pointsFor_1_Goal(){
		Defender defender = new Defender();
		
		assertTrue(defender.pointsFor(1) == 3);
	}
	
	@Test
	public void test_Midfielder_pointsFor_1_Goal(){
		Midfielder midfielder = new Midfielder();
		
		assertTrue(midfielder.pointsFor(1) == 1);
	}
	
	@Test
	public void test_Forward_pointsFor_1_Goal(){
		Forward forward = new Forward();
		
		assertTrue(forward.pointsFor(1) == 1);
	}
	
	@Test
	public void test_getPositionWithName_Goalkeeper(){	
		try {
			assertTrue(new Goalkeeper().equals(Position.getPositionWithName("Goalkeeper")));
		} catch (InstantiationException e) {
			fail("it's spell");
		} catch (IllegalAccessException e) {
			fail("it's name");
		} catch (ClassNotFoundException e) {
			fail("it's class");
		}
	}
	
}
