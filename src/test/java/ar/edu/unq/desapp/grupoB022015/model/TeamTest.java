package ar.edu.unq.desapp.grupoB022015.model;

import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.model.Team;
import ar.edu.unq.desapp.grupoB022015.model.builders.PlayerBuilder;
import ar.edu.unq.desapp.grupoB022015.model.builders.TeamBuilder;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.CantAddPlayerException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanElevenPlayersException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanFourMidfieldersException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanOneGoalkeeperException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanThreeDefendersException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanThreeForwardsException;
import junit.framework.TestCase;

public class TeamTest extends TestCase{

		
	@Test
	public void test_allPlayers_returnsAllPlayersInTheTeam(){
		Team team = TeamBuilder.anyTeam().withllPlayersAllowed().build();
		
		assertEquals(team.allPlayers().size(), 11);
	}
	
	@Test
	public void test_tryToAddMoreThanElevenPlayers_throwsNotAllowedMoreThanElevenPlayersException(){
		Team team = TeamBuilder.anyTeam().withllPlayersAllowed().build();
		try {
			team.addPlayer(PlayerBuilder.anyPlayer().build());
			fail();
		} catch (CantAddPlayerException e) {
			assertEquals(e.getClass(), NotAllowedMoreThanElevenPlayersException.class);
		}
	}
	
	@Test
	public void test_tryToAddMoreThanOneGoalkeeper_throwsNotAllowedMoreThanOneGoalkeeperException(){
		Team team = TeamBuilder.anyTeam().withXGoalkeepers(1).build();	
		try {
			team.addPlayer(PlayerBuilder.anyPlayer().goalkeeper().build());
			fail();
		} catch (CantAddPlayerException e) {
			assertEquals(e.getClass(), NotAllowedMoreThanOneGoalkeeperException.class);
		}			
		
	}
	
	@Test
	public void test_tryToAddMoreThanThreeDefenders_throwsNotAllowedMoreThanThreeDefendersException(){
		Team team = TeamBuilder.anyTeam().withXDefenders(3).build();	
		try {
			team.addPlayer(PlayerBuilder.anyPlayer().defender().build());
			fail();
		} catch (CantAddPlayerException e) {
			assertEquals(e.getClass(), NotAllowedMoreThanThreeDefendersException.class);
		}	
	}
	
	@Test
	public void test_tryToAddMoreThanFourMidfielders_throwsNotAllowedMoreThanFourMidfieldersException(){
		Team team = TeamBuilder.anyTeam().withXMidfielders(4).build();	
		try {
			team.addPlayer(PlayerBuilder.anyPlayer().midfielder().build());
			fail();
		} catch (CantAddPlayerException e) {
			assertEquals(e.getClass(), NotAllowedMoreThanFourMidfieldersException.class);
		}	
	}
	
	@Test
	public void test_tryToAddMoreThanThreeForwards_throwsNotAllowedMoreThanThreeForwardsException(){
		Team team = TeamBuilder.anyTeam().withXForwards(3).build();	
		try {
			team.addPlayer(PlayerBuilder.anyPlayer().forward().build());
			fail();
		} catch (CantAddPlayerException e) {
			assertEquals(e.getClass(), NotAllowedMoreThanThreeForwardsException.class);
		}	
	}
	
}
