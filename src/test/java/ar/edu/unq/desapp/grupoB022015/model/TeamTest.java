package ar.edu.unq.desapp.grupoB022015.model;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.model.builders.PlayerBuilder;
import ar.edu.unq.desapp.grupoB022015.model.builders.TeamBuilder;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.CantAddPlayerException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.CaptainMustBeATeamsPlayerException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanElevenPlayersException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanFourMidfieldersException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanOneGoalkeeperException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanThreeDefendersException;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.NotAllowedMoreThanThreeForwardsException;
import ar.edu.unq.desapp.grupoB022015.model.positions.Goalkeeper;
import ar.edu.unq.desapp.grupoB022015.model.positions.Position;
import junit.framework.TestCase;

public class TeamTest extends TestCase{

		
	@Test
	public void test_allPlayers_returnsAllPlayersInTeam(){
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
	
	@Test
	public void test_remove(){
		Team team = TeamBuilder.anyTeam().build();
		Player player = mock(Player.class);
		Players players = mock(Players.class);
		team.setPlayers(players);
		
		team.removePlayer(player);
		
		verify(players).removePlayer(player);
	}
	
	@Test
	public void test_addPlayerPoints(){
		Team team = TeamBuilder.anyTeam().build();
		team.addPlayerPoints(1);
		team.addPlayerPoints(2);
		team.addPlayerPoints(3);
		
		assertTrue(6 == team.getRoundPoints());
	}
	
	@Test
	public void test_resetRoundPoints(){
		Team team = TeamBuilder.anyTeam().build();
		
		team.addPlayerPoints(1);
		team.addPlayerPoints(2);
		team.addPlayerPoints(3);		
		assertTrue(6 == team.getRoundPoints());
		
		team.resetRoundPoints();		
		assertTrue(0 == team.getRoundPoints());
	}
	
	@Test
	public void test_setCaptain_positive(){
		Team team = TeamBuilder.anyTeam().build();
		Player player = mock(Player.class);
		Position position = mock(Goalkeeper.class);
		when(player.getPosition()).thenReturn(position);
		try{
			team.addPlayer(player);
		}catch(Exception e){
			fail();
		}
		
		try{
			team.setCaptain(player);
			assertTrue(team.getCaptain().equals(player));
		}catch (Exception e){
			fail();
		}
	}
	
	@Test
	public void test_whenTryToSetACaptainThatIsntInTheTeam_throwsException(){
		Team team = TeamBuilder.anyTeam().build();
		Player player = mock(Player.class);
				
		try{
			team.setCaptain(player);
			fail();
		}catch (CaptainMustBeATeamsPlayerException e){
			assertTrue(true);
		}
	}
	
}
