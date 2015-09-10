package persistence;

import java.util.ArrayList;
import ar.edu.unq.desapp.grupoB022015.model.Team;

public class TeamHome extends Home<Team>{

	//---------------------- Private ----------------------\\
	
	private static TeamHome instance;
	
	private TeamHome(){
		elems = new ArrayList<Team>();
	}
	
	//------------------- Public interface -------------------\\
	
	public static TeamHome getInstance(){
		if(instance == null)
			instance = new TeamHome();
		return instance;
	}
	

}
