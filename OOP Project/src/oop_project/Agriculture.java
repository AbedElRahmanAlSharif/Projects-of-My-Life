package oop_project;
import java.util.*;

public class Agriculture extends AnestheticLand implements LandPrice{
	private String cropToBeSeeded;

	public Agriculture() {
		super();
		cropToBeSeeded = "";
	}
	
	public Agriculture(int Nb, String nam, int Id, double Ar, double pr, String crop) {
		super(Nb, nam, Id, Ar, pr);
		cropToBeSeeded = crop;
	}
	
    public String getcropToBeSeeded() {
        return cropToBeSeeded;
    }

    public void setcropToBeSeeded(String cropToBeSeeded) {
        this.cropToBeSeeded = cropToBeSeeded;
    }
    
    public void display(){
        System.out.println("\nAgriculture land info:");
        super.display();
        System.out.printf(Locale.US,", crop to be seeded: %s, price of land: %.2f\n",cropToBeSeeded,priceOfLand());
    }
    
    public double priceOfLand() {
    	return area*PriceOfOneMeter;
    }
    
    public void ReadDetailsOfAgricultureLand(){
        Scanner ui = new Scanner(System.in);
        System.out.println("\nEnter the information of this agriculture land:");
        super.ReadAnestheticLandInformation();
        System.out.print("Enter the corps to be seeded: ");
        cropToBeSeeded = ui.next();
    }
    
    @Override
	public String toString() {
		return "Agriculture"+super.toString()+", Crop To Be Seeded = "+cropToBeSeeded+"\n-------------------------------------------------------------";
	}
}
