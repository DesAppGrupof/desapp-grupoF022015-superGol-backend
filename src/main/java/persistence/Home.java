package persistence;

import ar.edu.unq.desapp.grupoB022015.model.Id;

public abstract class Home<T> {
	
	public abstract T get(Id id);
	
	public abstract void save(T t);
}
