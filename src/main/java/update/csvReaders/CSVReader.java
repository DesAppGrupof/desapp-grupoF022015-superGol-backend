package update.csvReaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class CSVReader {
	
	String rootPath = "src\\main\\resources\\CSVs";
	BufferedReader reader;
	String line;
	String valuesDivision = ",";

	public void readFile() throws IOException{
		reader = new BufferedReader(new FileReader(csvFileRoute()));
		manageHeader(reader.readLine().split(valuesDivision));
		while (customCondition() && (line = reader.readLine()) != null) {
			String[] values = line.split(valuesDivision);
			manageRow(values);
		}			
	}
		
	protected abstract String csvFileRoute();
	protected abstract void manageHeader(String[] header);
	protected abstract void manageRow(String[] rowsValues);	
	protected abstract boolean customCondition();

}
