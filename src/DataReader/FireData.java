package DataReader;

import org.jetbrains.annotations.NotNull;

public class FireData implements Comparable<FireData>{
	private int day;
	private int month;
	private int year;
	private int temp;
	private int RH;
	private int Ws;
	private double Rain;
	private double FFMC;
	private double DMC;
	private double DC;
	private double ISI;
	private double BUI;
	private double FWI;
	private double Class;
	
	public FireData(){}
	public FireData(int day, int month, int year, int temp, int RH, int Ws, double Rain, double FFMC,
	                double DMC, double DC, double ISI, double BUI, double FWI, String Class)
	{
		this.day = day;
		this.FFMC = FFMC;
		this.month = month;
		this.RH = RH;
		this.Rain = Rain;
		this.temp = temp;
		this.year = year;
		this.Ws = Ws;
		this.DMC = DMC;
		this.DC = DC;
		this.ISI = ISI;
		this.BUI = BUI;
		this.FWI = FWI;
		if(Class.equals("fire"))
			this.Class = 1;
		else this.Class = 0;
	}
	public void showRH()
	{
		System.out.print("RH in this tuple is:"+this.RH);
	}
	public void showAll()
	{
		System.out.println("In this record --> day: "+day+" month: "+ month+" year: "+
					year + " temperature: "+ temp + " RH: "+" Ws: "+ Ws+" Rain: "+Rain+" FFMC: "+FFMC);
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getTemp() {
		return temp;
	}
	
	public int getRH() {
		return RH;
	}
	
	public int getWs() {
		return Ws;
	}
	
	public double getRain() {
		return Rain;
	}
	
	public double getFFMC() {
		return FFMC;
	}
	
	public double getDMC() {
		return DMC;
	}
	
	public double getDC() {
		return DC;
	}
	
	public double getISI() {
		return ISI;
	}
	
	public double getBUI() {
		return BUI;
	}
	
	public double getFWI() {
		return FWI;
	}
	
	public double getY() {
		return Class;
	}
	
	
	@Override
	public int compareTo(@NotNull FireData fd) {
		return this.RH - fd.RH;
	}
	//override the compareTo method(by RH value) making the FireData comparable
}

