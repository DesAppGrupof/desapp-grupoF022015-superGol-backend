package ar.edu.unq.desapp.grupoB022015.model;

public abstract class Persistible {

	protected Id id;
	
	public void setId(Id anId){
		id = anId;
	}
	
	public Id id(){
		return id;
	}
}
