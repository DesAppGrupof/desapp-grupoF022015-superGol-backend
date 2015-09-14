package ar.edu.unq.desapp.grupoB022015.model;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.model.builders.PlayerBuilder;
import ar.edu.unq.desapp.grupoB022015.model.positions.Defender;
import ar.edu.unq.desapp.grupoB022015.model.positions.Forward;
import ar.edu.unq.desapp.grupoB022015.model.positions.Goalkeeper;
import ar.edu.unq.desapp.grupoB022015.model.positions.Midfielder;
import ar.edu.unq.desapp.grupoB022015.model.positions.Position;
import junit.framework.TestCase;

public class PlayerTest extends TestCase{
	
	@Test
	public void test_aPlayerHasAPosition(){
		Player goalkeeper = PlayerBuilder.anyPlayer().goalkeeper().build();
		assertEquals(goalkeeper.getPosition(), new Goalkeeper());
	}
	
	@Test
	public void test_whenAskToAPlayerIfHeHasThePositionHeHas_returnTrue(){
		
		Player goalkeeper = PlayerBuilder.anyPlayer().goalkeeper().build();
		assertTrue(goalkeeper.hasPosition(new Goalkeeper()));
		
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
	
	@Test
	public void test_addTeam(){
		Player player = PlayerBuilder.anyPlayer().build();
		
		Team team = mock(Team.class);
		
		player.addTeam(team);
		
		assertTrue(player.getTeams().contains(team));
	}
	
	@Test
	public void test_whenactualizePlayersGoalsHeUpdatesAllTeamsThatHaveHim_ForGoalkeepers(){
		/* For each player's position the team owns different amount of points:
			Goalkeeper -> goals == 0 ? 3 : 0
		*/		
		
		Player goalkeeper = PlayerBuilder.anyPlayer().goalkeeper().build();
		
		Team team1 = mock(Team.class);
		Team team2 = mock(Team.class);
		
		goalkeeper.addTeam(team1);
		goalkeeper.addTeam(team2);

		goalkeeper.setGoalsInLastRound(0);
		verify(team1).addPlayerPoints(3);
		verify(team2).addPlayerPoints(3);
		
		goalkeeper.setGoalsInLastRound(1);		
		verify(team1).addPlayerPoints(0);
		verify(team2).addPlayerPoints(0);
	}
	
	@Test
	public void test_whenactualizePlayersGoalsHeUpdatesAllTeamsThatHaveHim_ForDefenders(){
		/* For each player's position the team owns different amount of points:
			Defender   -> 3 * goals
		*/
		
		Player defender = PlayerBuilder.anyPlayer().defender().build();
		
		Team team1 = mock(Team.class);
		Team team2 = mock(Team.class);

		defender.addTeam(team1);
		defender.addTeam(team2);

		defender.setGoalsInLastRound(1);

		verify(team1).addPlayerPoints(3);
		verify(team2).addPlayerPoints(3);
	}
	
	@Test
	public void test_whenactualizePlayersGoalsHeUpdatesAllTeamsThatHaveHim_ForMidfielders(){
		/* For each player's position the team owns different amount of points:
			Midfielder -> 1 * goals
		*/
		
		Player midfielder = PlayerBuilder.anyPlayer().midfielder().build();
		
		Team team1 = mock(Team.class);
		Team team2 = mock(Team.class);

		midfielder.addTeam(team1);
		midfielder.addTeam(team2);

		midfielder.setGoalsInLastRound(2);

		verify(team1).addPlayerPoints(2);
		verify(team2).addPlayerPoints(2);
	}
	
	@Test
	public void test_whenactualizePlayersGoalsHeUpdatesAllTeamsThatHaveHim_ForForwards(){
		/* For each player's position the team owns different amount of points:
			Forward    -> 1 * goals
		*/
		
		Player forward = PlayerBuilder.anyPlayer().forward().build();

		Team team1 = mock(Team.class);
		Team team2 = mock(Team.class);

		forward.addTeam(team1);
		forward.addTeam(team2);

		forward.setGoalsInLastRound(3);

		verify(team1).addPlayerPoints(3);
		verify(team2).addPlayerPoints(3);
	}
	
	@Test
	public void test_pointsInSeason(){
		Player defender = PlayerBuilder.anyPlayer().defender().build(); 	// I choose a defender becouse i love them
		
		defender.setGoalsInLastRound(3);
		defender.setGoalsInLastRound(2);
		defender.setGoalsInLastRound(1);
		
		assertTrue(defender.pointsInSeason() == 18);
	}
	
	@Test
	public void test_pointsInLastThreeRounds(){
		Player player = PlayerBuilder.anyPlayer().defender().build();

		player.setGoalsInLastRound(3);
		assertTrue(player.pointsInLastThreeRounds() == 9);

		player.setGoalsInLastRound(1);
		assertTrue(player.pointsInLastThreeRounds() == 12);
		
		player.setGoalsInLastRound(3);
		assertTrue(player.pointsInLastThreeRounds() == 21);
		
		player.setGoalsInLastRound(3);
		assertTrue(player.pointsInLastThreeRounds() == 21);
	}
	
	@Test
	public void test_averagePointsForRound(){
		Player defender = PlayerBuilder.anyPlayer().defender().build();
		
		defender.setGoalsInLastRound(3);
		defender.setGoalsInLastRound(2);
		defender.setGoalsInLastRound(1);
		
		assertTrue(defender.averagePointsForRound() == 6);
	}
	
	@Test
	public void test_getGoalsInLastRound(){
		Player player = PlayerBuilder.anyPlayer().build();		
		Position position = mock(Position.class);
		when(position.pointsFor(3)).thenReturn(3);
		player.setPosition(position);
		
		player.setGoalsInLastRound(3);
		
		assertTrue (3 == player.getGoalsInLastRound());
	}
	
	@Test
	public void test_name(){
		Player player = PlayerBuilder.anyPlayer().build();
		player.setName("name");
		
		assertEquals("name", player.getName());
	}
}
