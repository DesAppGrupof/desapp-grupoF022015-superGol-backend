package persistence;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
	
	public List<Player> bestPlayersInLastThreeRounds(){
		Comparator<Player> comparator = new Comparator<Player> (){
			@Override
			public int compare(Player player1, Player player2) {				
				return player2.pointsInLastThreeRounds() - player1.pointsInLastThreeRounds();
			}			
		};
		elems.sort(comparator);
		List<Player> bestPlayers = new ArrayList<Player>();
		for(int i = 0; i < 3; i++)
			bestPlayers.add(elems.get(i));
		
		return bestPlayers;
	}

}
