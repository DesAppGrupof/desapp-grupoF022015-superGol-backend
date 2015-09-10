package update.csvReaders;

import org.joda.time.DateTime;

import ar.edu.unq.desapp.grupoB022015.model.Id;
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
		
		UpdateManager.getInstance().newUpdate = update;
	}

	@Override
	protected void manageRow(String[] rowsValues){
		Id id = new Id(Integer.valueOf(rowsValues[0]));
		String position = rowsValues[1];
		Integer goals = Integer.valueOf(rowsValues[2]);

		UpdateManager.getInstance().addUncheckedPlayer(id, position, goals);
		
	}	

}