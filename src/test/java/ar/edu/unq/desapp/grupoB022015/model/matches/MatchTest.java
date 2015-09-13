package ar.edu.unq.desapp.grupoB022015.model.matches;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import ar.edu.unq.desapp.grupoB022015.model.Team;


public class MatchTest {
	
	protected Match match;
	protected Team team0;
	protected Team team1;
	
	@Before
	public void setUp() throws Exception {
		team0 = mock(Team.class);
		team1 = mock(Team.class);
		match = new Match(team0, team1);
	}
	
	@Test
	public void setScore() {
		int score0 = 4;
		int score1 = 5;
		
		match.setScore(score0, score1);
		Assert.assertEquals(score0, match.score0);
		Assert.assertEquals(score1, match.score1);
	}
	
	@Test
	public void getWinner_Player0() {
		match.setScore(2, 1);
		Assert.assertEquals(team0, match.getWinner());
	}
	
	@Test
	public void getWinner_Player1() {
		match.setScore(2, 11);
		Assert.assertEquals(team1, match.getWinner());
	}
	
	@Test
	public void getWinner_Draw() {
		match.setScore(1, 1);
		Assert.assertNull(match.getWinner());
	}

}
