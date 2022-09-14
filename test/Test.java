

//This test class is for reading and sorting the data by its RH value


import DataReader.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Test {
	public static void main(String[] arg) throws IOException {
		File file = new File("Data\\firedata.csv");
		Reader TestReader = new Reader();
		ArrayList<FireData> FDL = TestReader.read(file);
		Collections.sort(FDL);
		
		for(int i = 0 ; i < FDL.size(); i++)
		{
			FDL.get(i).showRH();
			System.out.print(" | ");
			FDL.get(i).showAll();
		}
		
	}
}
