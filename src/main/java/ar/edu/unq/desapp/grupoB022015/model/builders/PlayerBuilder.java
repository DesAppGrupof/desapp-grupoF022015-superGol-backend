package ar.edu.unq.desapp.grupoB022015.model.builders;

import ar.edu.unq.desapp.grupoB022015.model.Id;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.positions.Defender;
import ar.edu.unq.desapp.grupoB022015.model.positions.Forward;
import ar.edu.unq.desapp.grupoB022015.model.positions.Goalkeeper;
import ar.edu.unq.desapp.grupoB022015.model.positions.Midfielder;

public class PlayerBuilder{

	private Player player;
	
	private PlayerBuilder(){
		player = new Player();
	}
	
	//------------------ Interfaz publica ------------------\\
	
	public static PlayerBuilder anyPlayer(){
		return new PlayerBuilder();
	}
		
	public PlayerBuilder goalkeeper(){
		player.setPosition(new Goalkeeper());
		return this;
	}
	
	public PlayerBuilder defender(){
		player.setPosition(new Defender());
		return this;
	}
	
	public PlayerBuilder midfielder(){
		player.setPosition(new Midfielder());
		return this;
	}
	
	public PlayerBuilder forward(){
		player.setPosition(new Forward());
		return this;
	}
	
	public PlayerBuilder withId(Integer idNumber) {
		player.setId(new Id(idNumber));
		return this;
	}
	
	public Player build(){
		return player;
	}

	
}
