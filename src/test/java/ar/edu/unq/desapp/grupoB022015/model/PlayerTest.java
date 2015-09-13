package ar.edu.unq.desapp.grupoB022015.model;

import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.model.builders.PlayerBuilder;
import ar.edu.unq.desapp.grupoB022015.model.positions.Defender;
import ar.edu.unq.desapp.grupoB022015.model.positions.Forward;
import ar.edu.unq.desapp.grupoB022015.model.positions.GoalKeeper;
import ar.edu.unq.desapp.grupoB022015.model.positions.Midfielder;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

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

		goalkeeper.setGoalsInRound(0);
		verify(team1).addPlayerPoints(3);
		verify(team2).addPlayerPoints(3);
		
		goalkeeper.setGoalsInRound(1);		
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

		defender.setGoalsInRound(1);

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

		midfielder.setGoalsInRound(2);

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

		forward.setGoalsInRound(3);

		verify(team1).addPlayerPoints(3);
		verify(team2).addPlayerPoints(3);
	}
	
}
