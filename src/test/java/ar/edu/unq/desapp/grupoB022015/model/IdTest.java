package ar.edu.unq.desapp.grupoB022015.model;

import org.junit.Test;

import junit.framework.TestCase;

public class IdTest extends TestCase {

	@Test
	public void test_equals(){
		// Two ids are equals if both have the same number
		Id anId = new Id(0);
		Id anotherId = new Id(0);
		Id aThirthId = new Id(1);
		
		assertTrue(anId.equals(anotherId));
		assertFalse(anId.equals(aThirthId));
		assertFalse(aThirthId.equals(anotherId));
	}
}
