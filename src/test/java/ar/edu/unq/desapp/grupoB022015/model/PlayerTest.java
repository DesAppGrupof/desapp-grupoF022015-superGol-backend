package ar.edu.unq.desapp.grupoB022015.model;

import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.builders.PlayerBuilder;
import ar.edu.unq.desapp.grupoB022015.model.positions.Defender;
import ar.edu.unq.desapp.grupoB022015.model.positions.Forward;
import ar.edu.unq.desapp.grupoB022015.model.positions.GoalKeeper;
import ar.edu.unq.desapp.grupoB022015.model.positions.Midfielder;
import junit.framework.TestCase;

public class PlayerTest extends TestCase{
	
	@Test
	public void test_aPlayerHasAPosition(){
		Player goalkeeper = PlayerBuilder.anyPlayer().goalkeeper().build();
		assertEquals(goalkeeper.getPosition(), new GoalKeeper());
	}
	
	@Test
	public void test_whenAskToAPlayerIfHeHasThePositionHeHas_returnTrue(){
		
		Player goalkeeper = PlayerBuilder.anyPlayer().goalkeeper().build();
		assertTrue(goalkeeper.hasPosition(new GoalKeeper()));
		
		Player defender = PlayerBuilder.anyPlayer().defender().build();
		assertTrue(defender.hasPosition(new Defender()));
		
		Player midfielder = PlayerBuilder.anyPlayer().midfielder().build();
		assertTrue(midfielder.hasPosition(new Midfielder()));
		
		Player forward = PlayerBuilder.anyPlayer().forward().build();
		assertTrue(forward.hasPosition(new Forward()));
	}
	
	@Test
	public void test_playersAreEqualsIfBothHaveTheSameId(){
		Player player1 = PlayerBuilder.anyPlayer().withId(1).build();
		Player player2 = PlayerBuilder.anyPlayer().withId(1).build();
		
		assertTrue(player1.equals(player2));
	}
	
	@Test
	public void test_playerArentEqualsIfBothHaveDiferentsIds(){
		Player player1 = PlayerBuilder.anyPlayer().withId(1).build();
		Player player2 = PlayerBuilder.anyPlayer().withId(2).build();
		
		assertFalse(player1.equals(player2));
	}
}
