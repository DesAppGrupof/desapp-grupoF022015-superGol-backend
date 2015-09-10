package ar.edu.unq.desapp.grupoB022015.model.matches;

import java.util.ArrayList;
import java.util.List;

public class Round {
	
	protected List<Match> matches = new ArrayList<>();
	
	public Round(List<Match> matches) {
		this.matches = matches;
	}
	
	public List<Match> getMatches() {
		return matches;
	}

}
