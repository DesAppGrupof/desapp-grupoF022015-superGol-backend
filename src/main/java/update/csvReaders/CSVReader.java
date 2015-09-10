package update.csvReaders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class CSVReader {
	
	BufferedReader reader;
	String line;
	String valuesDivision = ",";

	public void readFile(){
		try {
			reader = new BufferedReader(new FileReader(csvFileRoute()));
			manageHeader(reader.readLine().split(valuesDivision));
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(valuesDivision);
				manageRow(values);
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
			
	}
		
	protected abstract String csvFileRoute();
	protected abstract void manageHeader(String[] header);
	protected abstract void manageRow(String[] rowsValues);	

}
