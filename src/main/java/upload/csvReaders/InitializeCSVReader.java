package upload.csvReaders;

import upload.InitializeManager;

public class InitializeCSVReader extends CSVReader{

	private InitializeManager manager;

	public InitializeCSVReader(InitializeManager manager){
		this.manager = manager;
	}
	
	@Override
	protected String csvFileRoute() {
		return rootPath + "initializePlayers.csv";
	}

	@Override
	protected void manageHeader(String[] header) {		
	}
	
	@Override
	protected void manageRow(String[] rowsValues) {
		manager.save(rowsValues[0], rowsValues[1], rowsValues[2]);
	}

	@Override
	protected boolean customCondition() {
		return true;
	}
}
