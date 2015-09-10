package ar.edu.unq.desapp.grupoB022015.model.matches;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.model.Team;
import org.junit.Assert;

public class LeagueTest {

	protected League league;

	protected void addTeamsToLeague(int qtyPlayers) {
		for (int i = 0; i < qtyPlayers; i++) {
			league.addTeam(mock(Team.class));
		}
	}

	@Before
	public void setUp() throws Exception {
		league = new League("league", 4, 20);
	}

	@Test
	public void getTeams() {
		Assert.assertTrue(league.getTeams().isEmpty());

		Team team = mock(Team.class);
		league.teams.add(team);

		Assert.assertEquals(1, league.getTeams().size());
		Assert.assertEquals(team, league.getTeams().get(0));
	}

	@Test
	public void addTeam() {
		Team team = mock(Team.class);
		Assert.assertTrue(!league.getTeams().contains(team));

		league.addTeam(team);
		Assert.assertTrue(league.getTeams().contains(team));
	}

	@Test
	public void removeTeam() {
		Team team = mock(Team.class);
		league.addTeam(team);
		Assert.assertTrue(league.getTeams().contains(team));

		league.removeTeam(team);
		Assert.assertTrue(!league.getTeams().contains(team));
	}

	@Test
	public void canInit() {
		for (int teams = 0; teams < league.getMinTeams(); teams++) {
			Assert.assertTrue(!league.canInit());
			league.addTeam(mock(Team.class));
		}
		Assert.assertTrue(league.canInit());

		for (int teams = league.getMinTeams(); teams <= league.getMaxTeams(); teams++) {
			Assert.assertTrue(league.canInit());
			league.addTeam(mock(Team.class));
		}

		Assert.assertTrue(!league.canInit());
	}

	@Test(expected = RuntimeException.class)
	public void init_NoTeams() {
		Assert.assertTrue(!league.canInit());
		league.init();
	}

	@Test(expected = RuntimeException.class)
	public void init_LessTeams() {
		league.addTeam(mock(Team.class));
		league.addTeam(mock(Team.class));
		Assert.assertTrue(league.getTeams().size() < league.getMinTeams());
		Assert.assertTrue(!league.canInit());
		league.init();
	}

	@Test(expected = RuntimeException.class)
	public void init_OverTeams() {
		for (int i = 0; i <= league.getMaxTeams(); i++) {
			league.addTeam(mock(Team.class));
		}
		Assert.assertTrue(!league.canInit());
		league.init();
	}

	@Test
	public void init() {
		Assert.assertTrue(!league.getRounds().isEmpty());
		Round round = mock(Round.class);
		league.getRounds().clear();
		league.rounds.add(round);

		addTeamsToLeague(league.getMinTeams());
		Assert.assertTrue(league.canInit());
		league.init();

		verify(round).init();
	}

	@Test(expected = RuntimeException.class)
	public void init_afterInited() {
		league.init();

		league.init();
	}
	
	@Test
	public void isInited() {
		Assert.assertTrue(!league.isInited());
		addTeamsToLeague(league.getMinTeams());
		league.init();
		Assert.assertTrue(league.isInited());
	}

}
