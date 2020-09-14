package framwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;


public class ReadCSV {
	
	public static List<String[]> readCSV(File file) throws IOException{
		List<String[]> withId = new ArrayList<String[]>();
		//List<String> details = new ArrayList<String>();
		java.util.List<String> headers = new ArrayList<String>();
		java.util.List<String[]> li = null;
//		Scanner scan = new Scanner(file);
		FileReader fileread = new FileReader(file);
		String line;
		CSVReader csv = new CSVReaderBuilder(fileread).build();
		li = csv.readAll();
		headers =  Arrays.asList(li.get(0));
		FileReader fileread1 = new FileReader(file);
		BufferedReader br = new BufferedReader(fileread1);
		while((line =br.readLine())!=null) {
	       String[] str = line.split(",",-1);
	       withId.add(str);
	    }
	   
		return withId;
	}
}
