package oop_project;
import java.io.IOException;
import java.io.File;
import java.util.*;

public class TestLand {
	public static Province getProvinceByName(HashMap<String,Province> prvs, String name) {
		Scanner ui = new Scanner(System.in);
		Province p = prvs.get(name);
		while(p == null) {
			System.out.print("Invalid Input! Enter new name: ");
			p = prvs.get(ui.next());
		}
		return p;
	}
	
	public static String getLandType(String type) {
		Scanner ui = new Scanner(System.in);
		while(!("AC".contains(type.toUpperCase()) && type.length() == 1)) {
			System.out.print("Invalid Input! Enter either 'A' or 'C': ");
			type = ui.next();
		}
		return type.toUpperCase();
	}
	
	public static Province checkProvince(HashMap<String,Province> prvs){
		Scanner ui = new Scanner(System.in);
		Province p;
		if (prvs.size() > 0) {
			System.out.print("Enter province's name: ");
			String name = ui.next();
			p = getProvinceByName(prvs,name);
		}
		else {
			System.out.println("You have to create a new province first!");
			System.out.print("Enter the province's name: ");
			String name = ui.next();
			System.out.print("Enter the size of the province: ");
			int size = ui.nextInt();
			p = new Province(size,name);
			prvs.put(name, p);
		}
		return p;
	}
	
	public static void main(String[] args) throws IOException {
		HashMap<String,Province> provinces = new HashMap<String,Province>();
		Scanner ui = new Scanner(System.in);
		int option;
		System.out.println("Choose an option from below:");
		System.out.println("1) Create a new province\n"
				+ "2) Add land to province\n"
				+ "3) Delete land from province\n"
				+ "4) Search for land by ID\n"
				+ "5) Display all lands in a province\n"
				+ "6) Find number of agriculture/construction lands\n"
				+ "7) Update a land by ID\n"
				+ "8) Merge two lands\n"
				+ "9) Split a land\n"
				+ "10) Export lands to text file\n"
				+ "11) Import agriculture/construction land info from text file\n"
				+ "12) Get price of agriculture/construction land by ID from text file\n"
				+ "13) Get price of land by ID\n"
				+ "14) Exit");
		System.out.print("\nYour option: ");
		option = ui.nextInt();
		while (option != 14) {
			while (!(option >= 1 || option <= 13)) {
				System.out.print("Invalid Input! Choose another option: ");
				option = ui.nextInt();
			}
			switch (option) {
			case 1: {
				System.out.print("Enter the name of the province: ");
				String name = ui.next();
				System.out.print("Enter the size of the province: ");
				int size = ui.nextInt();
				Province p = new Province(size,name);
				provinces.put(name,p);
				System.out.printf("A province of name :%s has been created successfully!\n",p.getName());
				break;
			}
			case 2: {
				Province p = checkProvince(provinces);
				System.out.print("Choose type of land (agriculture/construction). A/C? ");
				String type = ui.next();
				type = getLandType(type);
				if(type.equals("A")) {
					Agriculture a = new Agriculture();
					a.ReadDetailsOfAgricultureLand();
					p.AddAnestheticLand(a);
				}
				else {
					Construction c = new Construction();
					c.ReadDetailsOfConstructionLand();
					p.AddAnestheticLand(c);
				}
				break;
			}
			case 3:{
				Province p = checkProvince(provinces);
				System.out.print("Enter the ID of the land: ");
				int id = ui.nextInt();
				p.DeleteAnestheticLand(id);
				break;
			}
			case 4:{
				Province p = checkProvince(provinces);
				System.out.print("Enter the ID of the land: ");
				int id = ui.nextInt();
				int index = p.searchLandById(id);
				System.out.printf((index != -1)? "This land of id: %d in province of name: %s has an index of %d.\n":"This land of id: %d in province of name: %s does not exist!\n",id,p.getName(),index);
				break;
			}
			case 5:{
				Province p = checkProvince(provinces);
				p.displayAllLands();
				break;
			}
			case 6:{
				Province p = checkProvince(provinces);
				System.out.print("Choose type of land (agriculture/construction). A/C? ");
				String type = ui.next();
				type = getLandType(type);
				if (type.equals("A")) {
					System.out.printf("The number of agriculture lands in province of name: %s is: %d.\n",p.getName(),p.FindNumberOfAgricultureLands());
				}
				else {
					System.out.printf("The number of construction lands in province of name: %s is: %d.\n",p.getName(),p.FindNumberOfConstructionLands());
				}
				break;
			}
			case 7:{
				Province p = checkProvince(provinces);
				System.out.print("Enter the ID of the land: ");
				int id = ui.nextInt();
				p.UpdateLandInformation(id);
				break;
			}
			case 8:{
				Province p = checkProvince(provinces);
				System.out.print("Enter the ID of the first land: ");
				int id1 = ui.nextInt();
				System.out.print("Enter the ID of the second land: ");
				int id2 = ui.nextInt();
				p.MergeTwoLands(id1, id2);
				break;
			}
			
			case 9:{
				Province p = checkProvince(provinces);
				System.out.print("Enter the ID of the land: ");
				int id1 = ui.nextInt();
				System.out.print("Enter the ID of the new land: ");
				int id2 = ui.nextInt();
				System.out.print("Enter area split percentage out of 100: ");
				double percent = ui.nextDouble();
				p.SplitLand(id1, id2, percent);
				break;
			}
			case 10:{
				Province p = checkProvince(provinces);
				p.storeData(p.getName()+"_agriculture.txt", p.getName()+"_construction.txt");
				System.out.printf("The data of province of name: %s has been exported successfully!\n",p.getName());
				break;
			}
			case 11:{
				Province p = checkProvince(provinces);
				System.out.print("Choose type of land (agriculture/construction). A/C? ");
				String type = ui.next();
				type = getLandType(type);
				System.out.print("Enter the name of the text file with '.txt': ");
				String filename = ui.next();
				File file = new File(filename);
				while (!file.exists()) {
					System.out.print("Invalid Input! Enter correct file name with '.txt': ");
					filename = ui.next();
					file = new File(filename);
				}
				if (type.equals("A")) {
					p.TakeAgricultureInfoFromFile(filename);
				}
				else {
					p.TakeConstructionInfoFromFile(filename);
				}
				break;
			}
			case 12:{
				Province p = checkProvince(provinces);
				System.out.print("Choose type of land (agriculture/construction). A/C? ");
				String type = ui.next();
				type = getLandType(type);
				System.out.print("Enter the name of the text file with '.txt': ");
				String filename = ui.next();
				File file = new File(filename);
				while (!file.exists()) {
					System.out.print("Invalid Input! Enter correct file name with '.txt': ");
					filename = ui.next();
					file = new File(filename);
				}
				System.out.print("Enter the ID of the land: ");
				int id = ui.nextInt();
				if (type.equals("A")) {
					double price = p.PriceOfAgricultureLandById(filename, id);
					if(price > 0) {
						System.out.printf(Locale.US,"The price of the land of id: %d in the province of name: %s is: %.2f.\n",id,p.getName(),price);
					}
				}
				else {
					double price = p.PriceOfConstructionLandById(filename, id);
					if (price > 0) {
						System.out.printf(Locale.US,"The price of the land of id: %d in the province of name: %s is: %.2f.\n",id,p.getName(),price);
					}
				}
				break;
			}
			case 13:{
				Province p = checkProvince(provinces);
				System.out.print("Enter the ID of the land: ");
				int id = ui.nextInt();
				double price = p.SecondMethodToFindPriceOfLandById(id);
				if(price > 0) {
					System.out.printf(Locale.US,"The price of the land of id: %d in the province of name: %s is: %.2f.\n",id,p.getName(),price);
				}
				break;
			}
			default: break;
		}
			System.out.print("\nWhat do you want to do next? Enter an option: ");
			option = ui.nextInt();
	}
		System.out.println("You have existed the code!\nHave a nice day!\nYour data has been exported automatically.");
		provinces.forEach((key,value)->{
			try {
				value.storeData(value.getName()+"_agriculture.txt", value.getName()+"_construction.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
