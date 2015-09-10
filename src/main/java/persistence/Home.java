package persistence;

import java.util.List;

import ar.edu.unq.desapp.grupoB022015.model.Id;
import ar.edu.unq.desapp.grupoB022015.model.Persistible;

public abstract class Home<T extends Persistible> {
	
	protected List<T> elems;
	private Integer nextId = 0;
	
	public T get(Id anId){
		T tWithSerchedId = null;
		for(T t : elems){
			if (t.id() == anId)
				tWithSerchedId = t;
		}
				
		return tWithSerchedId;
	}
	
	public void save(T t) {
		t.setId(new Id(nextId));
		nextId++;
		elems.add(t);
	}
	
	public boolean existIdentifier(Id anId){
		boolean exists = false;
		for(T t : elems){
			exists = exists || t.id() == anId;
		}
				
		return exists;
	}
	
	public List<T> all(){
		return elems;
	}
}
