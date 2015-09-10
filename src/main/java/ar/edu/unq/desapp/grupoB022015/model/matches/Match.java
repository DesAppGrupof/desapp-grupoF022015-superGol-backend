package ar.edu.unq.desapp.grupoB022015.model.matches;

import ar.edu.unq.desapp.grupoB022015.model.Team;

public class Match {
	
	protected Team team0;
	protected Team team1;
	
	protected int score0;
	protected int score1;
	
	public Match(Team team0, Team team1) {
		this.team0 = team0;
		this.team1 = team1;
	}
	
	public void setScore(int scoreTeam0, int scoreTeam1) {
		score0 = scoreTeam0;
		score1 = scoreTeam1;
	}

	public Team getTeam0() {
		return team0;
	}

	public Team getTeam1() {
		return team1;
	}

}
