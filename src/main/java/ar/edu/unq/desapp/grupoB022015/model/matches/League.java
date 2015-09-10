package ar.edu.unq.desapp.grupoB022015.model.matches;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import ar.edu.unq.desapp.grupoB022015.model.Team;

public class League {
	
	protected String name;
	protected int minTeams;
	protected int maxTeams;
	protected List<Team> teams;
	protected List<Round> rounds;
	
	public League(String name, int minTeams, int maxTeams) {
		this.name = name;
		this.minTeams = minTeams;
		this.maxTeams = maxTeams;
		teams = new ArrayList<>();
		rounds = new ArrayList<>();
	}
	
	public void init() throws RuntimeException {
		if (!canInit()) {
			throw new RuntimeException("League can not init");
		}
		if (isInited()) {
			throw new RuntimeException("League has already begun");
		}
		arrangeRounds();
	}
	
	protected void arrangeRounds() {
		List<Team> teams = getTeams();
		int qtyTeams = teams.size();
		int qtyMatches = (qtyTeams + 1) / 2;
		boolean oddTeams = qtyTeams % 2 != 0;
		int qtyRounds = oddTeams ? qtyTeams : qtyTeams - 1;
        Collections.shuffle(teams, new Random());
        
		for (int round = 0; round < qtyRounds; round++) {
	        List<Match> matches = new ArrayList<>(qtyMatches);
			int team0 = oddTeams ? 1 : 0;
			int team1 = qtyTeams - 1;
			if (!oddTeams && round % 2 != 0) {
				matches.add(new Match(teams.get(team1--), teams.get(team0++)));
			}
			while (team0 < qtyMatches) {
				matches.add(new Match(teams.get(team0++), teams.get(team1--)));
			}
			getRounds().add(new Round(matches));
			
			Team lastTeam = teams.get(teams.size() - 1);
			teams.remove(teams.size() - 1);
			teams.add(oddTeams ? 0 : 1, lastTeam);
		}
	}
	
	public boolean isInited() {
		return !getRounds().isEmpty();
	}

	public boolean canInit() {
		return teams.size() >= getMinTeams() && teams.size() <= getMaxTeams();
	}
	
	public void addTeam(Team team) {
		teams.add(team);
	}
	
	public void removeTeam(Team team) {
		teams.remove(team);
	}
	
	public List<Team> getTeams() {
		return teams;
	}
	
	public int getMinTeams() {
		return minTeams;
	}
	
	public int getMaxTeams() {
		return maxTeams;
	}
	
	public List<Round> getRounds() {
		return rounds;
	}

}
