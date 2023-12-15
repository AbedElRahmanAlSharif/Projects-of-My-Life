package oop_project;
import java.util.*;
public abstract class AnestheticLand extends Country implements LandPrice{
	protected String NameOfPerson;
	protected int idOfland;
	protected double area;
	protected double PriceOfOneMeter;
	
	public AnestheticLand() {
		this(0,"",0,0,0); //"this" calls the constructor below in order to set all values to their default values
	}
	
	public AnestheticLand(int Nb, String na, int Id, double Ar, double pr) {
		CountryNumber = Nb;
		NameOfPerson = na;
		idOfland = Id;
		area = Ar;
		PriceOfOneMeter = pr;
	}
	
	public AnestheticLand(AnestheticLand L) { //copy constructor
		CountryNumber = L.getCountryNumber();
		NameOfPerson = L.getPerson();
		idOfland = L.getId();
		area = L.getArea();
		PriceOfOneMeter = L.getPrice();
	}
	
	public int getCountryNumber() {
		return CountryNumber;
	}
	
	public String getPerson() {
		return NameOfPerson;
	}
	
	public int getId() {
		return idOfland;
	}
	
	public double getArea() {
		return area;
	}
	
	public double getPrice() {
		return PriceOfOneMeter;
	}
	
	public void setCountryNumber(int nb) {
		CountryNumber = nb;
	}
	
	public void setPerson(String name) {
		NameOfPerson = name;
	}
	
	public void setId(int id) {
		idOfland = id;
	}
	
	public void setArea(double ar) {
		area = ar;
	}
	
	public void setPrice(double pr) {
		PriceOfOneMeter = pr;
	}
	
	public void display() { //displays all info of a land
		System.out.printf(Locale.US,"Country number: %d, Name of person: %s, Id of land: %d, Area: %.2f, Price of meter: %.2f",CountryNumber,NameOfPerson,idOfland,area,PriceOfOneMeter);
	}
	
	public void ReadAnestheticLandInformation() { //asks user for all input of the land
		Scanner ui = new Scanner(System.in);
		System.out.print("Enter the country's number: ");
		CountryNumber = ui.nextInt();
		System.out.print("Enter the name of the owner: ");
		NameOfPerson = ui.next();
		System.out.print("Enter the id of the land: ");
		idOfland = ui.nextInt();
		System.out.print("Enter the area of the land: ");
		area = ui.nextDouble();
		System.out.print("Enter the price of one meter: ");
		PriceOfOneMeter = ui.nextDouble();
	}

	@Override
	public String toString() {
		return " Land:\nCountry Number = "+CountryNumber+", Name Of Person = " + NameOfPerson + ", ID = " + idOfland + ", Area = " + area
				+ ", Price Of One Meter = " + PriceOfOneMeter;
	}
}
