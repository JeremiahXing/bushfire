


import DataReader.FireDataMatrix;
import org.ujmp.core.Matrix;
import org.ujmp.core.calculation.Calculation;



public class LogisticRegression {
	public Matrix generateTheta(FireDataMatrix M,int trianingNum) //generate a matrix of Theta(a column vector)
	{
		Matrix X = M.getX().subMatrix(Calculation.Ret.NEW,0,0,trianingNum - 1,10);
		Matrix Y = M.getY().subMatrix(Calculation.Ret.NEW,0,0,trianingNum - 1,0);
		//Y.showGUI();
		Matrix theta = (((X.transpose().mtimes(X)).pinv()).mtimes(X.transpose())).mtimes(Y);
		return theta;
	}
	public double sigmoid(Matrix theta, Matrix X_i)     //
	{
		double s;
		double z;
		z = theta.mtimes(X_i).getAsDouble(0,0);
		s = 1/(1 + Math.exp(-1 * z));
		return s;
	}
	public void printTestFeedback(Matrix Theta, FireDataMatrix FM, int trainingNum)
	{
		double Precision = 0;
		double Recall = 0;
		double TPR = 0;     //True positive rate
		double FPR = 0;     //False positive rate
		double Beta = 1.5;     // Beta > 0
		double F_Beta = 0;  //F_Beta measurement
		
		double sigmoidY = 0;
		double TP = 0; // true positive
		double FN = 0; // false negative
		double FP = 0; // false positive
		double TN = 0; // true negative
		
		for(int i = trainingNum; i < FM.getRecordNumber(); i++)
		{
			sigmoidY = sigmoid(FM.getX().selectRows(Calculation.Ret.NEW,i),Theta);
			if(sigmoidY >= 0.5)  //Calculating the positive result (both True Positive and False Positive)
			{
				if(FM.getY().getAsInt(i,0) == 1) // True Positive
					TP++;
				else FP++;      //False Negative
			}
			else        //sigmoid < flagValue | Calculating the negative result (both True Negative and False Negative)
			{
				if(FM.getY().getAsInt(i,0) == 1) // False Negative
					FN++;
				else TN++;
			}
		}
		
		Precision = TP/(TP + FP);
		Recall = TP/(TP + FN);
		TPR = TP/(TP + FN);
		FPR = FP/(TN + FP);
		F_Beta = (1+Beta*Beta)*Precision*Recall/((Beta*Beta*Precision)+Recall);
		System.out.println("In this LR process: ");
		System.out.println("    Precision value is " + Precision);
		System.out.println("    Recall value is "+ Recall);
		System.out.println("    True positive rate is "+TPR);
		System.out.println("    False positive rate is: "+FPR);
		System.out.println("    When Beta is 1.5 the F_Beta measurement is "+F_Beta);
	}
	
}
