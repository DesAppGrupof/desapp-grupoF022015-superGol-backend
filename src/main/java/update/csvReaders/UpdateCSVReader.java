package update.csvReaders;

import org.joda.time.DateTime;

import ar.edu.unq.desapp.grupoB022015.model.Id;
import ar.edu.unq.desapp.grupoB022015.model.exceptions.InvalidUpdateDataException;
import ar.edu.unq.desapp.grupoB022015.model.positions.Position;
import update.Update;
import update.UpdateManager;

public class UpdateCSVReader extends CSVReader {

	private Integer version;
	
	public UpdateCSVReader(Integer aVersion){
		version = aVersion;
	}
	
	@Override
	protected String csvFileRoute() {
		// TODO
		return "..." + version.toString();
	}

	@Override
	protected void manageHeader(String[] header) {		
		Update update = new Update();
		update.id = header[0];
		update.updateNumber = version;
		update.updateDate = DateTime.now();
		
		UpdateManager.getInstance().setNewUpdate(update);
	}

	@Override
	protected void manageRow(String[] rowsValues){
		Id id = new Id(Integer.valueOf(rowsValues[0]));
		Position position = null;
		try {
			position = (Position) Class.forName(rowsValues[1]).newInstance();
		} catch (InstantiationException e) {} 
		  catch (IllegalAccessException e) {}
		  catch (ClassNotFoundException e) {}
		Integer goals = Integer.valueOf(rowsValues[2]);
		
		try{
			UpdateManager.getInstance().addUncheckedPlayer(id, position, goals);
		}catch(InvalidUpdateDataException e){
			UpdateManager.getInstance().cancelUpdate(version);
		}
		
		
	}

	@Override
	protected boolean customCondition() {
		return UpdateManager.getInstance().continueUpdate();
	}	

}
