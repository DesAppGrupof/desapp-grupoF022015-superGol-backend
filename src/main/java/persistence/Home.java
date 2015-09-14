package persistence;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.Id;
import ar.edu.unq.desapp.grupoB022015.model.Persistible;

public abstract class Home<T extends Persistible> {
	
	//---------------------- Private ----------------------\\
	
	protected List<T> elems;
	private Integer nextId = 0;
	
	//---------------------- Public ----------------------\\

	public void save(T t) {
		t.setId(new Id(nextId));
		nextId++;
		elems.add(t);
	}	

	public boolean existIdentifier(Id anId){
		boolean exists = false;
		for(T t : elems){
			exists = exists || t.id().equals(anId);
		}
				
		return exists;
	}
	
	public T get(Id anId){
		T tWithSerchedId = null;
		for(T t : elems){
			if (t.id().equals(anId))
				tWithSerchedId = t;
		}
				
		return tWithSerchedId;
	}
		
	public List<T> all(){
		return elems;
	}
	
	public void reset(){
		elems = new ArrayList<T>();
		nextId = 0;
	}
}
