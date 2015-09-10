package persistence;

import java.util.ArrayList;

import ar.edu.unq.desapp.grupoB022015.model.Player;

public class PlayerHome extends Home<Player> {

	//---------------------- Private ----------------------\\
	
	private static PlayerHome instance;
	
	private PlayerHome(){
		elems = new ArrayList<Player>();
	}
	
	//------------------- Public interface -------------------\\
	
	public static PlayerHome getInstance(){
		if(instance == null)
			instance = new PlayerHome();
		return instance;
	}
	

}
