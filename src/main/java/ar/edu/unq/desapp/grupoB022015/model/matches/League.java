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
		int qtyTeams = getTeams().size();
		int qtyMatches = (qtyTeams + 1) / 2;
		boolean dummyTeam = qtyTeams % 2 == 0;
		int qtyRounds = dummyTeam ? qtyTeams : qtyTeams - 1;
        Collections.shuffle(getTeams(), new Random());
        
        List<Match> matches = new ArrayList<>(qtyMatches);
//		if (dummyTeam) {
//			getTeams().add(new Team());
//		}
		for (int round = 0; round < qtyRounds; round++){ 
			for (int match = dummyTeam ? 1 : 0; match < qtyMatches; match++) {
//				matches.add(new Match(team0, team1));
			}
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
