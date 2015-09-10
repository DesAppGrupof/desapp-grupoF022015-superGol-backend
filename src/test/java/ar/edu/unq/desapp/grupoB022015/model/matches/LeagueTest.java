package ar.edu.unq.desapp.grupoB022015.model.matches;

import static org.mockito.Mockito.mock;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.model.Team;

public class LeagueTest {

	protected League league;

	protected void addTeamsToLeague(int qtyPlayers) {
		for (int i = 0; i < qtyPlayers; i++) {
			league.addTeam(mock(Team.class));
		}
	}
	
	protected List<Team> addAndGetTeamsToLeague(int qtyPlayers) {
		List<Team> teams = new ArrayList<>();
		for (int i = 0; i < qtyPlayers; i++) {
			Team team = mock(Team.class);
			teams.add(team);
			league.addTeam(team);
		}
		return teams;
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
	
	@Test
	public void arrangeRounds_EvenTeams_RoundsAndMatchesQty() {
		int qtyTeams = 8;
		addTeamsToLeague(qtyTeams);
		league.arrangeRounds();
		List<Round> rounds = league.getRounds();
		Assert.assertEquals(qtyTeams - 1, rounds.size());
		for (int i = 0; i < rounds.size(); i++) {
			Assert.assertEquals(qtyTeams / 2, rounds.get(i).getMatches().size());
		}
	}

	@Test
	public void arrangeRounds_OddTeams_RoundsAndMatchesQty() {
		int qtyTeams = 11;
		addTeamsToLeague(qtyTeams);
		league.arrangeRounds();
		List<Round> rounds = league.getRounds();
		Assert.assertEquals(qtyTeams, rounds.size());
		for (int i = 0; i < rounds.size(); i++) {
			Assert.assertEquals(qtyTeams / 2, rounds.get(i).getMatches().size());
		}
	}
	
	
	private void arrangeRounds_TeamsNotRepeated(int qtyTeams) {
		List<Team> teams = addAndGetTeamsToLeague(qtyTeams);
		league.arrangeRounds();
		List<Round> rounds = league.getRounds();
		for (int r = 0; r < rounds.size(); r++) {
			Round round = rounds.get(r);
			List<Team> teamsAux = new ArrayList<>();
			teamsAux.addAll(teams);
			for (int m = 0; m < round.getMatches().size(); m++) {
				Match match = round.getMatches().get(m);
				Team team0 = match.getTeam0();
				Team team1 = match.getTeam1();
				Assert.assertTrue(teamsAux.contains(team0));
				Assert.assertTrue(teamsAux.contains(team1));
				teamsAux.remove(team0);
				teamsAux.remove(team1);
			}
		}
	}
	
	@Test
	public void arrangeRounds_EvenTeams_TeamsNotRepeated() {
		arrangeRounds_TeamsNotRepeated(10);
	}
	
	@Test
	public void arrangeRounds_OddTeams_TeamsNotRepeated() {
		arrangeRounds_TeamsNotRepeated(13);
	}
	
	private void arrangeRounds_TeamsWellDistributed(int qtyTeams) {
		addTeamsToLeague(qtyTeams);
		league.arrangeRounds();
		List<Team> teams = league.getTeams();
		List<Round> rounds = league.getRounds();
		List<Point> matches = new ArrayList<>();
		for (int r = 0; r < rounds.size(); r++) {
			Round round = rounds.get(r);
			for (int m = 0; m < round.getMatches().size(); m++) {
				Match match = round.getMatches().get(m);
				Team team0 = match.getTeam0();
				Team team1 = match.getTeam1();
				int team0Pos = teams.indexOf(team0);
				int team1Pos = teams.indexOf(team1);
				Point point = new Point(team0Pos, team1Pos);
				Point point2 = new Point(team1Pos, team0Pos);
				Assert.assertTrue(!matches.contains(point));
				Assert.assertTrue(!matches.contains(point2));
				matches.add(new Point(team0Pos, team1Pos));
			}
		}
	}
	
	@Test
	public void arrangeRounds_EvenTeams_TeamsWellDistributed() {
		arrangeRounds_TeamsWellDistributed(12);
	}
	
	@Test
	public void arrangeRounds_OddTeams_TeamsWellDistributed() {
		arrangeRounds_TeamsWellDistributed(11);
	}

}
