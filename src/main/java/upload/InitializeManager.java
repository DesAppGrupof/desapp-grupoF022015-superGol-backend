package upload;

import java.io.IOException;

import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.positions.Position;
import persistence.PlayerHome;
import upload.csvReaders.InitializeCSVReader;

public class InitializeManager {

	
	public void run() throws IOException{
		new InitializeCSVReader(this).readFile();;
	}
	
	public void save(String name, String positionName, String realTeam){
		Player player = new Player();
		try {
			player.setName(name);
			player.setPosition(Position.getPositionWithName(positionName));
			player.setRealTeam(realTeam);
			PlayerHome.getInstance().save(player);
		} catch (Exception e) {}
	}
}
