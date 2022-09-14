

//This Solution class is about machine learning

import DataReader.FireDataMatrix;
import org.ujmp.core.Matrix;

import java.io.File;
import java.io.IOException;



class Solution {
	public static void main(String[] arg) throws IOException {
		
		File f = new File("Data\\newFireData.csv");
		FireDataMatrix FM = new FireDataMatrix();
		FM.setMatrix(f);
		
		
		//FM.getX().showGUI();
		//FM.getY().showGUI();
		
		LogisticRegression LR = new LogisticRegression();
		int trainingNum = 180;
		Matrix Theta = LR.generateTheta(FM,trainingNum);
		
		
		
		for(int i = 1; i <= 100; i++)
		{
			System.out.print("<" + i + ">");
			LR.printTestFeedback(Theta,FM,trainingNum);
		}
		
		//Theta.showGUI();
		
	}
}
