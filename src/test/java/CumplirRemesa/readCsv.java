package CumplirRemesa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class readCsv {

	public static void main(String[] args) throws  IOException, CsvValidationException {
		
		CSVReader reader = new CSVReader (new FileReader("CSVdata\\Pendientes_Manifiesto.csv"));

		// reading the data of the CSV file

		StringBuffer buffer = new StringBuffer();
		String data[];

		while ((data = reader.readNext()) !=null) {

		    for(int i=0 ; i<data.length ; i++){
		         System.out.print(data[i] +" " ) ;
			}
		    
		    System.out.println("");
		}
	
	}
	
	}

