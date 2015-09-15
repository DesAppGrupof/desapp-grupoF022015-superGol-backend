package update.csvReaders;

public class InitializeCSVReader extends CSVReader{

	@Override
	protected String csvFileRoute() {
		return rootPath + "initializeCSV.csv";
	}

	@Override
	protected void manageHeader(String[] header) {
		
	}
	
	@Override
	protected void manageRow(String[] rowsValues) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean customCondition() {
		// TODO Auto-generated method stub
		return false;
	}
}
