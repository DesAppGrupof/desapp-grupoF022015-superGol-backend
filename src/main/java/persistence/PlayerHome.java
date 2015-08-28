package persistence;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.Id;
import ar.edu.unq.desapp.grupoB022015.model.Player;

public class PlayerHome extends Home<Player> {

	//---------------------- Private ----------------------\\
	
	private List<Player> players;
	private static PlayerHome instance;
	
	private PlayerHome(){
		players = new ArrayList<Player>();
	}
	
	//------------------- Public interface -------------------\\
	
	public static PlayerHome getInstance(){
		if(instance == null)
			instance = new PlayerHome();
		return instance;
	}
	
	@Override
	public Player get(Id id) {
		Player playerWithSerchedId = null;
		for(Player p : players){
			if (p.id() == id)
				playerWithSerchedId = p;
		}
		
		if(playerWithSerchedId == null){
			//TODO
		}
		
		return playerWithSerchedId;
	}

	@Override
	public void save(Player aPlayer) {
		players.add(aPlayer);
	}

}
