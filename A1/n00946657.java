/*
 * Author: Allan Lim
 * N#: N00946657
 * Course: COP3503
 * Assignment #: 1
 * Due Date: 1/20/2017
 */
 
 import java.util.Scanner;
 
 /**
  * Calculates the cost of driving based on user input
  */
  
 public class n00946657 {
 
 public static void main(String[] args) {
 // Variable declaration
 double distance;
 double mpg; 
 double ppg;
 double cost;
 Scanner input = new Scanner(System.in);
 System.out.print("Enter the driving distance: ");
 distance = input.nextDouble(); 
 System.out.print("Enter miles per gallon: ");
 mpg = input.nextDouble();
 System.out.print("Enter price per gallon: ");
 ppg = input.nextDouble();
 // Calculates the total cost of driving based on previous inputs
 cost = (distance / mpg) * ppg;
 System.out.printf("The cost of driving is $" + "%.2f", cost);
 }
 
 }