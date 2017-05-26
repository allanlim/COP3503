/*
 * Author: Allan Lim
 * N#: N00946657
 * Course: COP3503
 * Assignment #: 4
 * Due Date: 3/13/2017
 */

import java.util.Scanner; 
import java.io.FileNotFoundException; 
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;

/**
 * The main class of our program that handles reading the file and storing data into an array that can be sorted and printed
 */
public class n00946657 {

	public static void main(String[] args) throws FileNotFoundException{

	if(args.length <= 0){
			System.out.print("null");
		}

/**
 * Scans the files to be read and creates an object of it
 */
	File file = new File (args[0]);
	Scanner input = new Scanner (file);

/**
 * Creates an array containing the information of all automobiles from the file
 */
	ArrayList<Vehicle> arrayOfVehicles = new ArrayList <Vehicle>();
	   while (input.hasNextLine()) {
		   String line = input.nextLine();

				if(line.equals("vehicle")){
					 String name = input.nextLine();
					 String address = input.nextLine();
					 String phone = input.nextLine();
					 String email = input.nextLine();
					 arrayOfVehicles.add(new Vehicle(name, address, phone, email));
				}

				else if(line.equals("car")){
					 String name = input.nextLine();
					 String address = input.nextLine();
					 String phone = input.nextLine();
					 String email = input.nextLine();
					 boolean convertible = input.nextBoolean();
					 input.nextLine();
					 String color = input.nextLine();
					 arrayOfVehicles.add(new Car(name, address, phone, email, convertible, color));
				}

				else if(line.equals("american car")){
					 String name = input.nextLine();
					 String address = input.nextLine();
					 String phone = input.nextLine();
					 String email = input.nextLine();
					 boolean convertible = input.nextBoolean();
					 input.nextLine();
					 String color = input.nextLine();
					 boolean detroit = input.nextBoolean();
					 boolean unionshop = input.nextBoolean();
					 arrayOfVehicles.add(new AmericanCar(name, address, phone, email, convertible, color, detroit, unionshop));

				}

				else if(line.equals("foreign car")){
					 String name = input.nextLine();
					 String address = input.nextLine();
					 String phone = input.nextLine();
					 String email = input.nextLine();
					 boolean convertible = input.nextBoolean();
					 input.nextLine();
					 String color = input.nextLine();
					 String country = input.nextLine();
					 float importduty = input.nextFloat();
					 input.nextLine();
					 arrayOfVehicles.add(new ForeignCar(name, address, phone, email, convertible, color, country, importduty));

				}

				else if(line.equals("bicycle")){
					 String name = input.nextLine();
					 String address = input.nextLine();
					 String phone = input.nextLine();
					 String email = input.nextLine();
					 int speeds = input.nextInt();
					 input.nextLine();
					 arrayOfVehicles.add(new Bicycle(name, address, phone, email, speeds));

				}

				else if(line.equals("truck")){
					 String name = input.nextLine();
					 String address = input.nextLine();
					 String phone = input.nextLine();
					 String email = input.nextLine();
					 float tons = input.nextFloat();
					 float costoftruck = input.nextFloat();
					 input.nextLine();
					 String datepurchased = input.nextLine();
					 arrayOfVehicles.add(new Truck(name, address, phone, email, tons, costoftruck,datepurchased));
				}
      } 
input.close();



//Prints all the records
   System.out.println("These are all the records printed from the data file: \n");
	printAll(arrayOfVehicles);
	System.out.print("-------------------------------------------------------\n");

//Prints all the records sorted by email
	System.out.println("\nThese are all the vehicles sorted by email: \n");
	sortedArray(arrayOfVehicles);
	System.out.print("-------------------------------------------------------\n");

//Prints the number of records
	printRecords(arrayOfVehicles);
	System.out.print("\n-------------------------------------------------------\n");

//Prints the bicycle and truck records only
	System.out.println("\nThese are all the vehicles that are just bicycles and trucks: \n");
	bikeAndTrucks(arrayOfVehicles);
	System.out.print("\n-------------------------------------------------------\n");

//Prints the records with the "987" area code
	System.out.println("\nThese are all the vehicless with the (987) area code: \n");
	areaCode(arrayOfVehicles);
	System.out.print("\n-------------------------------------------------------\n");
    
}

/**
 * This method prints all the elements in the array extracted from the data file
 */
   public static void printAll(ArrayList<Vehicle> array){
	   for(int i = 0; i <= array.size() - 1; i++){
			System.out.print(array.get(i).toString());
			System.out.print("\n");
		}
	}

/**
 * This method sorts the array by email addresses and prints out th new sorted array
 */
   public static void sortedArray(ArrayList<Vehicle> array){
	   Collections.sort(array, new compareEmail());
			for(int i = 0; i<= array.size()-1; i++){
			   System.out.print(array.get(i).toString());//(2)
				System.out.print("\n");
			}
      }

/**
 * This method prints out how many records were stored in the array
 */
   public static void printRecords(ArrayList<Vehicle> array){
		System.out.print("The total amount of vehicles recorded are: " + array.size());
      }

/**
 * This method sorts all instances of bicycles and trucks in the array and prints them out
 */
   public static void bikeAndTrucks(ArrayList<Vehicle> array){
	   for(int i = 0; i<= array.size()-1; i++){
		   if(array.get(i) instanceof Bicycle){
			   System.out.print(array.get(i).toString());
				System.out.print("\n");
				}
			else if(array.get(i) instanceof Truck){
				System.out.print(array.get(i).toString());
				System.out.print("\n");
				}
			}
	   } 

/**
 * This method prints all records of vehicles in the area code of 987
 */
   public static void areaCode(ArrayList<Vehicle> array){
	   String number;
		for(int i = 0; i<= array.size()-1; i++){
		   number = array.get(i).getPhone();
		      if(number.substring(1,4).equals("987")){
				   System.out.print(array.get(i).toString());
					System.out.print("\n");
					}
         }
      }

}

/**
 * This compares the emails and sorts them
 */
class compareEmail implements Comparator <Vehicle>{
	@Override
	public int compare(Vehicle one, Vehicle two){
		Vehicle p1 = (Vehicle) one;
		Vehicle p2 = (Vehicle) two;
		return (p1.getEmail().compareTo(p2.getEmail()));
	}
}

/**
 * The parent class of all vehicles
 */
class Vehicle{
   private String ownername;
	private String address;
	private String phone;
	private String email;

   public Vehicle(){
      }

/**
 * Constructor for all vehicle records which contains methods to set and get certain aspects from the records
 */
	public Vehicle (String ownername, String address, String phone, String email){
	   this.ownername = ownername;
		this.address = address;
		this.phone = phone;
		this.email = email;
		}

	public String getOwnername(){
		return ownername;
		}

	public void setOwnername(String newOwnername){
		ownername = newOwnername;
		}
      
	public String getAddress(){
		return address;
		}

	public void setAddress(String newAddress){
		address = newAddress;
		}

	public String getPhone(){
		return phone;
		}

	public void setPhone (String newPhone){
		phone = newPhone;
		}

	public String getEmail(){
		return email;
		}

	public void setEmail(String newEmail){
		email = newEmail;
		}

	public boolean equals (Object obj){
		return true;
		}

	public String toString(){
		return "Vehicle\n" + "Owner's Name: " + getOwnername() + "\nAddress: "+ getAddress() + "\nPhone Number: " + getPhone() + "\nEmail: " + getEmail() + "\n";
		}
}

/**
 * A child class of the Vehicle class which is a constructor for all car records which contains methods to set and get certain aspects from the records
 */
class Car extends Vehicle{

   private boolean convertible;
	private String color;

   public Car(){
      }
	
   public Car (String ownername, String address, String phone, String email, boolean convertible, String color){
		super(ownername, address, phone, email);
		setConvertible(convertible);
		setColor(color);
		}

	public boolean getConvertible(){
		return convertible;
		}

	public void setConvertible(boolean newConvertible){
		convertible = newConvertible;
		}

	public String getColor (){
		return color;
		}

	public void setColor(String newColor){
		color = newColor;
		}

	public boolean equals (Object obj){
		return true;
		}

	@Override
	public String toString(){
	   return "Car\n" + "Owner's Name: " + getOwnername() + "\nAddress: "+ getAddress() + "\nPhone Number: " + getPhone() + "\nEmail: " + getEmail() + "\nConvertible: "+ getConvertible()  + "\nColor: " + getColor() + "\n";
		}
}

/**
 * A child class of the Car class which is a constructor for all American Car records which contains methods to set and get certain aspects from the records
 */
class AmericanCar extends Car{

	private boolean detroit;
	private boolean unionshop;

	public AmericanCar(){
      }

	public AmericanCar(String ownername, String address, String phone, String email, boolean convertible, String color, boolean detroit, boolean unionshop){
		super(ownername, address, phone, email, convertible, color);
		setDetroit(detroit);
		setUnionshop(unionshop);
      }

   public boolean getDetroit(){
		return detroit;
		}

	public void setDetroit(boolean newDetroit){
		detroit = newDetroit;
		}

	public boolean getUnionshop(){
		return unionshop;
		}

	public void setUnionshop(boolean newUnionshop){
		unionshop = newUnionshop;
		}

	public boolean equals (Object obj){
		return true;  
      }

	@Override
	public String toString(){
		return "American Car\n" + "Owner's Name: " + getOwnername() + "\nAddress: "+ getAddress() + "\nPhone Number: " + getPhone() + "\nEmail: " + getEmail() + "\nConvertible: "+ getConvertible()  + "\nColor: " + getColor() + "\nMade in Detroit: " + getDetroit() + "\nMade in a Union Shop: "+ getUnionshop() + "\n";
		}

}

/**
 * A child class of the Car class which is a constructor for all Foregin Car records which contains methods to set and get certain aspects from the records
 */
class ForeignCar extends Car{

   private String country;
	private float importduty;

	public ForeignCar(){
      }

	public ForeignCar(String ownername, String address, String phone,String email, boolean convertible, String color, String country, float importduty){
		super(ownername, address, phone, email, convertible, color);
		setCountry(country);
		setImportduty(importduty);
      }

   public String getCountry(){
      return country;
		}

	public void setCountry(String newCountry){
		country = newCountry;
		}

	public float getImportduty(){
		return importduty;
		}

	public void setImportduty(float newImportduty){
		importduty = newImportduty;
		}

	public boolean equals (Object obj){
		return true;
      }

   @Override
	public String toString(){
			return "Foreign Car\n" + "Owner's Name: " + getOwnername() + "\nAddress: "+ getAddress() + "\nPhone Number: " + getPhone() + "\nEmail: " + getEmail() + "\nCountry: "+ getCountry() + "\nImport Duty: " + getImportduty() + "\n";

		}
	}

/**
 * A child class of the Vehicle class which is a constructor for all Bicycle records which contains methods to set and get certain aspects from the records
 */
class Bicycle extends Vehicle{

   private int speeds;

   public Bicycle(){
      }

	public Bicycle (String ownername, String address, String phone, String email, int speeds){
	   super(ownername, address, phone, email);
		setSpeeds(speeds);
		}

	public int getSpeeds(){
		return speeds;
		}

	public void setSpeeds(int newSpeeds){
		speeds = newSpeeds;
		}

	public boolean equals (Object obj){
		return true;
      }

   @Override
	public String toString(){
	   return "Bicycle\n" + "Owner's Name: " + getOwnername() + "\nAddress: "+ getAddress() + "\nPhone Number: " + getPhone() + "\nEmail: " + getEmail() + "\nSpeeds: " + getSpeeds() + "\n";
      }

}

/**
 * A child class of the Vehicle class which is a constructor for all Truck records which contains methods to set and get certain aspects from the records
 */
class Truck extends Vehicle{

   private float tons;
	private float costoftruck;
	private String datepurchased;

	public Truck(){
      }
		
   public Truck(String ownername, String address, String phone, String email, float tons, float costoftruck, String datepurchased){
		super(ownername, address, phone, email);
		setTons(tons);
		setCostoftruck(costoftruck);
		setDatepurchased(datepurchased);
      }

	public float getTons(){
		return tons;
		}

	public void setTons(float newTons){
		tons = newTons;
		}

	public float getCostoftruck(){
		return costoftruck;
		}

	public void setCostoftruck(float newCostoftruck){
		costoftruck = newCostoftruck;
		}
		
   public String getDatepurchased(){
		return datepurchased;
		}

	public void setDatepurchased(String newDatepurchased){
		datepurchased = newDatepurchased;
		}

	public boolean equals (Object obj){
		return true;
		}

   @Override
	public String toString(){
	   return "Truck\n" + "Owner's Name: " + getOwnername() + "\nAddress: "+ getAddress() + "\nPhone Number: " + getPhone() + "\nEmail: " + getEmail() + "\nTons: "+ getTons() + "\nTruck Cost: "+ getCostoftruck() + "\nDate Purchased: " + getDatepurchased() + "\n";
		}

}