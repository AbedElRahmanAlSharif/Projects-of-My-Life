package oop_project;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;

public class Province {
	private String name;
	private int NumberOfAnestheticLands;
	private AnestheticLand[] L;
	
	public Province(int size, String s) {
		name = s;
		NumberOfAnestheticLands = 0;
		L = new AnestheticLand[size];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFull() { //Done
		if (NumberOfAnestheticLands > 0) {
		    for(int i = 0; i<L.length; i++) {
		        if (L[i] == null) {
		        	return false;
		        }    
		    }
		    return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isEmpty() { //Done
		if (NumberOfAnestheticLands > 0) {
		    for(int i = 0; i<L.length; i++) {
		    	if (L[i] != null) {
		    		return false;
		    	}
		    }
		}
	    return true;
	}
	
	public boolean AddAnestheticLand(AnestheticLand land) { //Done
	    if(!isFull()) {
	    	for(int i = 0; i < L.length; i++) {
	    		if (L[i] == null) {
	    			L[i] = land;
	    			NumberOfAnestheticLands++;
	    			System.out.println("The land of id = "+land.getId()+" has been added succesfully!");
	    			return true;
	    		}
	    	}
	    }
	    System.out.println("The province is full!");
	    return false;
	}
	
	public boolean DeleteAnestheticLand(int idland) { //Done
		int index = searchLandById(idland);
		if(index == -1) {
			System.out.println("The non-existent land of id = "+idland+" cannot be deleted!");
			return false;
		}
		else {
			L[index] = null;
			System.out.println("The land of id = "+idland+" has been removed successfully!");
			NumberOfAnestheticLands--;
			return true;
		}
	}
	
	public int searchLandById(int I) { //Done
		for(int i = 0; i<L.length; i++) {
			if(L[i] != null) {
				if(L[i].getId() == I) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public void displayAllLands() { //Done
		for (AnestheticLand l: L) {
			if(l != null) {
				l.display();
			}
		}
	}
	
	public int FindNumberOfAgricultureLands() { //Done
		int count = 0;
		for (int i = 0; i<L.length; i++) {
			count = (L[i] instanceof Agriculture)? count+1: count;
		}
		return count;
	}
	
	public int FindNumberOfConstructionLands() { //Done
		int count = 0;
		for (int i = 0; i<L.length; i++) {
			count = (L[i] instanceof Construction)? count+1: count;
		}
		return count;
	}
	
	public boolean UpdateLandInformation(int idLand) throws IOException { //Done
		int index = searchLandById(idLand);
		if (index != -1) {
			System.out.println("\nProvide the new information: ");
			if (L[index] instanceof Agriculture) {
				((Agriculture) L[index]).ReadDetailsOfAgricultureLand();
			}
			else {
				((Construction) L[index]).ReadDetailsOfConstructionLand();
			}
			System.out.println("The land has been updated!");
			this.storeData(name+"_agriculture.txt", name+"_construction.txt");
			return true;
		}
		else {
			System.out.println("\nA non-existent land cannot be updated!");
			return false;
		}
	}
	
	public boolean MergeTwoLands(int idOfLand1, int idOfLand2) throws IOException { //Done
		int index1 = searchLandById(idOfLand1);
		int index2 = searchLandById(idOfLand2);
		if (index1 == -1 || index2 == -1) {
			System.out.println("\nThe lands cannot be merged if one of them doesn't exist!");
			return false;
		}
		else {
			AnestheticLand L1 = L[index1];
			AnestheticLand L2 = L[index2];
			if (L1 instanceof Agriculture && L2 instanceof Agriculture) {
				((Agriculture) L1).setcropToBeSeeded(((Agriculture) L2).getcropToBeSeeded());
			}
			else if(L1 instanceof Construction && L2 instanceof Construction) {
				((Construction) L1).setNumberOfLevels(((Construction) L2).getNumberOfLevels());
				((Construction) L1).setTypeOfSoil(((Construction) L2).getTypeOfSoil());
			}
			else {
				System.out.println("\nCannot merge two lands of different types!");
				return false;
			}
			L1.setCountryNumber(L2.getCountryNumber());
			L1.setPerson(L2.getPerson());
			L1.setArea(L2.getArea());
			L1.setPrice(L2.getPrice());
			L[index2] = null;
			this.NumberOfAnestheticLands--;
			this.storeData(name+"_agriculture.txt", name+"_construction.txt");
			System.out.println("\nThe lands have been merged successfully!");
			return true;
		}
	}
	
	public boolean SplitLand(int idPre, int idNew, double Percent) throws IOException { //Done
		int indexPre = searchLandById(idPre);
		if (indexPre == -1) {
			System.out.println("Non-existent land cannot be split!");
			return false;
		}
		else {
			AnestheticLand LPre = L[indexPre];
			String name = LPre.getPerson();
			int country_nb = LPre.getCountryNumber();
			double area = LPre.getArea()*Percent/100;
			double meter = LPre.getPrice();
			LPre.setArea(LPre.getArea()*(1-Percent/100));
			
			if (LPre instanceof Agriculture) {
				String crop = ((Agriculture) LPre).getcropToBeSeeded();
				AnestheticLand LNew = new Agriculture(country_nb, name, idNew, area, meter, crop);
				AddAnestheticLand(LNew);
			}
			else {
				int levels = ((Construction) LPre).getNumberOfLevels();
				String soil = ((Construction) LPre).getTypeOfSoil();
				AnestheticLand LNew = new Construction(country_nb, name, idNew, area, meter, levels, soil);
				AddAnestheticLand(LNew);
			}
			System.out.println("Land has been split succesfully!");
			this.storeData(this.name+"_agriculture.txt", this.name+"_construction.txt");
			return true;
		}
	}
	
	public void storeData(String AgrFileName, String ConFileName) throws IOException { //Done
		FileWriter agrfile = new FileWriter(AgrFileName);
		FileWriter confile = new FileWriter(ConFileName);
		if(!isEmpty()) {
			for (int i = 0; i < L.length; i++) {
				if(L[i] != null) {
					if (L[i] instanceof Agriculture) {
						agrfile.write(L[i].toString()+"\n");
					}
					else {
						confile.write(L[i].toString()+"\n");
					}
				}
			}
			agrfile.close();
			confile.close();
		}
	}
	
	@SuppressWarnings("resource")
	public Agriculture[] TakeAgricultureInfoFromFile(String filName) throws IOException { //Done
		FileReader agrifile =  new FileReader(filName);
		BufferedReader agribuffered = new BufferedReader(agrifile);
		String line;
		String[] input;
		int i = 0;
		int count = 0;
		while((line = agribuffered.readLine()) != null) {
			count = (line.contains("Agriculture"))? count+1: count;
		}
		Agriculture[] results = new Agriculture[count];
		agribuffered = new BufferedReader(new FileReader(filName)); // reset the reader
		while((line = agribuffered.readLine()) != null) {
			if(!(line.contains("-") || line.contains("Agriculture") || line.contains("\n"))) {
				line = line.replaceAll(" ", "");
				input = line.split(",",6);
				int countrynb = Integer.parseInt(input[0].substring(14));
				String name = input[1].substring(13);
				int id = Integer.parseInt(input[2].substring(3));
				double area = Double.parseDouble(input[3].substring(5));
				double priceofmeter = Double.parseDouble(input[4].substring(16));
				String crops = input[5].substring(15);
				results[i] = new Agriculture(countrynb, name, id, area, priceofmeter, crops);
				i++;
			}
			else {
				continue;
			}
		}
		System.out.println();
		agrifile.close();
		agribuffered.close();
		for(Agriculture l: results) {
			this.AddAnestheticLand(l);
		}
		this.storeData(this.name+"_agriculture.txt", this.name+"_construction.txt");
		return results;
	}
	
	@SuppressWarnings("resource")
	public Construction[] TakeConstructionInfoFromFile(String filName) throws IOException { //Done
		FileReader confile =  new FileReader(filName);
		BufferedReader conbuffered = new BufferedReader(confile);
		String line;
		String[] input;
		int i = 0;
		int count = 0;
		while((line = conbuffered.readLine()) != null) {
			count = (line.contains("Construction"))? count+1: count;
		}
		Construction[] results = new Construction[count];
		conbuffered = new BufferedReader(new FileReader(filName)); // reset the reader
		while((line = conbuffered.readLine()) != null) {
			if(!(line.contains("-") || line.contains("Construction") || line.contains("\n"))) {
				line = line.replaceAll(" ", "");
				input = line.split(",");
				int countrynb = Integer.parseInt(input[0].substring(14));
				String name = input[1].substring(13);
				int id = Integer.parseInt(input[2].substring(3));
				double area = Double.parseDouble(input[3].substring(5));
				double priceofmeter = Double.parseDouble(input[4].substring(16));
				int levels = Integer.parseInt(input[5].substring(15));
				String soil = input[6].substring(11);
				results[i] = new Construction(countrynb, name, id, area, priceofmeter, levels, soil);
				i++;
			}
		}
		System.out.println();
		confile.close();
		conbuffered.close();
		for(Construction l: results) {
			this.AddAnestheticLand(l);
		}
		this.storeData(this.name+"_agriculture.txt", this.name+"_construction.txt");
		return results;
	}

	public double PriceOfAgricultureLandById(String filName, int id) throws IOException { //Done
		Agriculture[] lands = TakeAgricultureInfoFromFile(filName);
		for (Agriculture l: lands) {
			if (l.getId() == id) {
				return l.priceOfLand();
			}
		}
		return 0;
	}
	
	public double PriceOfConstructionLandById(String filName, int id) throws IOException { //Done
		Construction[] lands = TakeConstructionInfoFromFile(filName);
		for (Construction l: lands) {
			if (l.getId() == id) {
				return l.priceOfLand();
			}
		}
		return 0;
	}
	
	public double SecondMethodToFindPriceOfLandById(int id) { //Done
		int index = this.searchLandById(id);
		if (index != -1) {
			return L[index].priceOfLand();
		}
		System.out.println("A non-existent land has no price!");
		return 0;
	}
}
