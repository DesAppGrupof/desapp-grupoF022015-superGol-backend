package upload;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.positions.Position;
import persistence.PlayerHome;
import upload.csvReaders.InitializeCSVReader;

public class InitializeManager {

	private void generateTemplateCSV() {
		try {
			PrintWriter template = new PrintWriter("src\\main\\resources\\CSVs\\UpdateCSVs\\templateCSV.csv");
			for(Player p : PlayerHome.getInstance().all()){
				template.println(p.id().number() + ";" + p.getName() + ";" + p.getPosition().getClass().getSimpleName() );
			}
			template.close();
		} catch (FileNotFoundException e) {	}
	}
	
	// ------------------------ Public ---------------------\\
	public void run() throws IOException{
		new InitializeCSVReader(this).readFile();
		generateTemplateCSV();
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
