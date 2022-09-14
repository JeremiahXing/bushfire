package DataReader;

import org.jetbrains.annotations.NotNull;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import org.ujmp.core.calculation.Calculation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class FireDataMatrix {
	private Matrix M;
	
	private int CaseNumber; // The number of cases
	private int RecordNumber; // The number of record
	
	public Matrix getX() {
		return M.subMatrix(Calculation.Ret.NEW,0,0,RecordNumber - 1,10);
	}
	
	public Matrix getY() { return M.selectColumns(Calculation.Ret.NEW,11);	}
	
	
	
	public Matrix getM(){ return M; }
	public int getCaseNumber() {
		return CaseNumber;
	}
	
	public int getRecordNumber() {
		return RecordNumber;
	}
	
	public @NotNull
	void setMatrix(@NotNull File f) throws IOException
	{
		Reader R = new Reader();
		ArrayList<FireData> FDL = R.read(f);
		Collections.shuffle(FDL);
		Matrix M = DenseMatrix.Factory.ones(FDL.size() , 12);
		//Matrix Y = DenseMatrix.Factory.ones(FDL.size() , 1);
		
		for(int i = 0; i < FDL.size(); i++)
		{
			M.setAsInt(FDL.get(i).getTemp(),i,1);
			M.setAsInt(FDL.get(i).getRH(),i,2);
			M.setAsInt(FDL.get(i).getWs(),i,3);
			M.setAsDouble(FDL.get(i).getRain(),i,4);
			M.setAsDouble(FDL.get(i).getFFMC(),i,5);
			M.setAsDouble(FDL.get(i).getDMC(),i,6);
			M.setAsDouble(FDL.get(i).getDC(),i,7);
			M.setAsDouble(FDL.get(i).getISI(),i,8);
			M.setAsDouble(FDL.get(i).getBUI(),i,9);
			M.setAsDouble(FDL.get(i).getFWI(),i,10);
			
			M.setAsDouble(FDL.get(i).getY(),i,11);
		}
		this.M = M;
		this.CaseNumber = 10;
		this.RecordNumber = FDL.size();
	}
	
}
