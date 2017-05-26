/*
 * Author: Allan Lim
 * N#: N00946657
 * Course: COP3503
 * Assignment #: 2
 * Due Date: 1/28/2017
 */
 
 import java.util.Scanner;
 
 /**
  * Calculates the sum of the series and approximation of pi based on user input 
  */
  
 public class n00946657 {
 
 public static void main(String[] args) {
 // Variable declaration
 int denominator; 
 Scanner input = new Scanner(System.in);
 System.out.print("Enter a single odd positive integer to be the last denominator for a series: ");
 denominator = input.nextInt(); 
 System.out.printf("Sum of the given series based on the last denominator being " + denominator + " is " + "%.12f", findSeries(denominator));
 System.out.print("\n");
 System.out.printf("Approximate of pi based on the last denominator being " + denominator +  " in the given series is " + "%.12f", findPis(denominator));
 }
 
 /**
  * Finds the sum of the given series based on the user input for the last denominator
  * @return The sum of the series
  */
 public static double findSeries(int denominator) {
 int a = 1;
 double b = 0.0;
 double c = 0.0;
 double sum = 0.0;
 int d = denominator - 2;
 
 while(a <= d){
 b = a + 2;
 c = (double)(a/b);
 sum = sum + c;
 a = a + 2;
 }
 return sum;
 }
 
 /**
  * Approximates pi for the given series based on the user input for the last denominator
  * @return The approximation of pi based on the series
  */
 public static double findPis(int denominator) {
 double sum = 0.0; 
 double pi = 0.0; 
 int j = (denominator - 1) / 2;
 for (int i = 1; i <= j; i++) {
     double num = (Math.pow(-1.0 , i + 1.0) / ((2.0 * i) - 1.0));
        sum = sum + num;
        if (i % j == 0)
        pi =(4.0 * sum);  
 }
 return pi;
 }

}