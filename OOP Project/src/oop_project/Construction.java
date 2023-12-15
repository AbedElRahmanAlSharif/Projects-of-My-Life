package oop_project;
import java.util.*;

public class Construction extends AnestheticLand{
	private int numberOfLevels;
	private String typeOfSoil;
	
	public Construction() {
		super();
		numberOfLevels = 0;
		typeOfSoil = "";
	}
	
	public Construction(int Nb, String name, int Id, double Ar, double pr, int nbLv, String soil) {
		super(Nb, name, Id, Ar, pr);
		numberOfLevels = nbLv;
		typeOfSoil = soil;
	}
	
	public Construction(int t, String soil) {
		super();
		numberOfLevels = t;
		typeOfSoil = soil;
	}

	public int getNumberOfLevels() {
		return numberOfLevels;
	}

	public void setNumberOfLevels(int numberOfLevels) {
		this.numberOfLevels = numberOfLevels;
	}

	public String getTypeOfSoil() {
		return typeOfSoil;
	}

	public void setTypeOfSoil(String typeOfSoil) {
		this.typeOfSoil = typeOfSoil;
	}
	
	public double priceOfLand() {
		return area*PriceOfOneMeter;
	}
	
	public void display() {
		System.out.println("\nConstruction Land Information: ");
		super.display();
		System.out.printf(Locale.US,", price of land: %.2f\n",priceOfLand());
	}
	
	public void ReadDetailsOfConstructionLand() {
		Scanner ui = new Scanner(System.in);
		System.out.println("\nEnter the information of this construction land:");
		super.ReadAnestheticLandInformation();
		System.out.print("Enter the number of levels: ");
		numberOfLevels = ui.nextInt();
		System.out.print("Enter the type of soil: ");
		typeOfSoil = ui.next();
	}
	
	@Override
	public String toString() {
		return "Construction"+super.toString()+", Number Of Levels = "+numberOfLevels+", Type Of Soil = "+typeOfSoil+"\n-------------------------------------------------------------";
	}
}
