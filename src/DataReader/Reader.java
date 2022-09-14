package DataReader;

import com.csvreader.*;
import org.jetbrains.annotations.NotNull;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



public class Reader {
	//Three getting data methods are offered in the Reader class
	
	
	public @NotNull
	ArrayList<FireData> read(@NotNull File f) throws IllegalArgumentException, IOException
	{
		ArrayList<FireData> FireDataList = new ArrayList<FireData>();
		CsvReader csvReader = new CsvReader(f.getPath());
		csvReader.readHeaders();
		while(csvReader.readRecord())
		{
			int day = Integer.parseInt(csvReader.get("day"));
			int month = Integer.parseInt(csvReader.get("month"));
			int year = Integer.parseInt(csvReader.get("year"));
			int temp = Integer.parseInt(csvReader.get("Temperature"));
			int RH = Integer.parseInt(csvReader.get("RH"));
			int Ws = Integer.parseInt(csvReader.get("Ws"));
			double Rain = Double.parseDouble(csvReader.get("Rain"));
			double FFMC = Double.parseDouble(csvReader.get("FFMC"));
			double DMC = Double.parseDouble(csvReader.get("DMC"));
			double DC = Double.parseDouble(csvReader.get("DC"));
			double ISI = Double.parseDouble(csvReader.get("ISI"));
			double BUI = Double.parseDouble(csvReader.get("BUI"));
			double FWI = Double.parseDouble(csvReader.get("FWI"));
			String Class = csvReader.get("Classes");
	
			
			FireData fd = new FireData(day,month,year,temp,RH,Ws,Rain,FFMC,DMC,DC,ISI,BUI,FWI,Class);
			FireDataList.add(fd);
		}
		return FireDataList;
	}
	
	
}
