package ar.edu.unq.desapp.grupoB022015.model.builders;

import ar.edu.unq.desapp.grupoB022015.model.Team;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.CantAddPlayerException;

public class TeamBuilder {
	private Team team;
	
	private TeamBuilder(){
		team = new Team();
	}
	
	public static TeamBuilder anyTeam(){
		TeamBuilder instance = new TeamBuilder();
		return instance;
	}
	
	public Team build(){
		return team;
	}

	public TeamBuilder withXGoalkeepers(int x) {
		for(int i = 0; i < x; i++){
			try {
				team.addPlayer(PlayerBuilder.anyPlayer().goalkeeper().build());
			} catch (CantAddPlayerException e) {
				e.printStackTrace();
			}
		}
		return this;
	}
	
	public TeamBuilder withXDefenders(int x) {
		for(int i = 0; i < x; i++){
			try {
				team.addPlayer(PlayerBuilder.anyPlayer().defender().build());
			} catch (CantAddPlayerException e) {
				e.printStackTrace();
			}
		}
		return this;
	}
	
	public TeamBuilder withXMidfielders(int x) {
		for(int i = 0; i < x; i++){
			try {
				team.addPlayer(PlayerBuilder.anyPlayer().midfielder().build());
			} catch (CantAddPlayerException e) {
				e.printStackTrace();
			}
		}
		return this;
	}
	
	public TeamBuilder withXForwards(int x) {
		for(int i = 0; i < x; i++){
			try {
				team.addPlayer(PlayerBuilder.anyPlayer().forward().build());
			} catch (CantAddPlayerException e) {
				e.printStackTrace();
			}
		}
		return this;
	}

	public TeamBuilder withllPlayersAllowed() {
		return this.withXGoalkeepers(1).withXDefenders(3).withXMidfielders(4).withXForwards(3);
	}
}
