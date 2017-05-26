/*
 * Author: Allan Lim
 * N#: N00946657
 * Course: COP3503
 * Assignment #: 3
 * Due Date: 2/11/2017
 */
 
 import java.util.Scanner;
 
 /**
  * Creates 2 two-dimensional arrays based on user input for the elements and compares them using different methods
  */
  
 public class n00946657 {
 
 /**
  * The main method that collects users input and calls other methods from the Strict class to compare the arrays
  */
 public static void main(String[] args) {
 // Creat object of scanner class
 Scanner input = new Scanner(System.in);
 // Creates the two-dimensional arrays with int type
 int m1[][] = new int[3][3];
 int m2[][] = new int[3][3];
 // Gets the user input to create elements for first array
 System.out.print("Enter 9 integer elements for 1st array: ");
 for(int row = 0; row < m1.length; row++)
 {
   for(int column = 0; column < m1[row].length; column++)
   {
      m1[row][column] = input.nextInt();
   }
 }     
 // Gets the user input to create elements for second array
 System.out.print("Enter 9 integer elements for 2nd array: ");
 for(int row = 0; row < m2.length; row++)
 {
   for(int column = 0; column < m2[row].length; column++)
   {
      m2[row][column] = input.nextInt();
   }
 }
 // Does a boolean check and based on whether the returned value is true or false dictates what is printed     
 boolean result = Strict.equals(m1, m2);
   if(result == true)
      System.out.println("The two arrays are strictly identical");
   else
      System.out.println("The two arrays are not strictly identical");
// Prints the cell values that are identical
 System.out.println("There are " + Strict.howmany(m1, m2) + " cell values that are identical between the arrays");
// Prints the cell values that are identical along the diagonal  
 System.out.println("There are " + Strict.diagonal(m1, m2) + " cell values that are identical along the diagonal between the arrays");
// Prints the average of all cell values
 System.out.println("The average of all cell values in the arrays is " + Strict.average(m1, m2));
// Prints the values of the array that are odd in rectangular form
 System.out.println("The values of the arrays that are odd in rectangular form: ");
 Strict.display(m1, m2);
 System.out.print("\n");
// Does a boolean check and based on whether the returned value is true or false dictates what is printed     
 boolean silly = Strict.silly(m1, m2);
   if(silly == true)
      System.out.println("The two arrays have all numbers satisfying 1 < numbers <=10");
   else
      System.out.println("The two arrays don't have all numbers satisfying 1 < numbers <=10");
 }
}

 class Strict {

 /** 
  * Compares the two arrays to check if all the elements are the same
  * @return Depending on whether a number is found in the array will make it return false otherwise check will remain true
  */
 public static boolean equals(int m1[][], int m2[][]) {
 boolean check = true;  
 for(int i = 0; i < m1.length; i++)
 {
   for (int j = 0; j < m2.length; j++)
   {
      if(m1[i][j] != m2[i][j])
         check = false;
   }
 }
 return check;
}   
 

/**
 * Returns how many cell values are identical in the two arrays
 * @return Returns the count of cell values that are identical between both arrays
 */
 public static int howmany(int m1[][], int m2[][]) {
 int count = 0;
 for(int i = 0; i < m1.length; i++)
 {
   for (int j = 0; j < m1.length; j++)
   {
      if(m1[i][j] == m2[i][j])
   {
   count++;
   }
 }
 }
 return count;
} 

/**
 * Returns how many cell values are identical along the diagonal
 * @return Returns the count of how many cell values are identical in cells [0][0], [1][1], and [2][2]
 */
 public static int diagonal(int m1[][], int m2[][]) {
 int count = 0;
 for(int i = 0; i < m1.length; i++)
 {
   for (int j = 0; j < m1.length; j++)
   {
      if(i == j)
      {
         if(m1[i][j] == m2[i][j])
         {
         count++;
         }
      }
   }  
 }
 return count;
}        

/**
 * Returns the average of all the cell values from the arrays
 * @return Returns the average of all cell values
 */
 public static double average(int m1[][], int m2[][]) {
 double average = 0.0;
   for(int i = 0; i < m1.length; i++)
   {
      for (int j = 0; j < m1.length; j++)
      { 
      average += (m1[i][j] + m2[i][j]);
      }
   }
   return average/18;      
}

/** 
 * Displays only those values of the arrays that are odd in rectangular form
 */
 public static void display(int m1[][], int m2[][]) {
 System.out.println("Array 1:");
 for(int i = 0; i < 1; i++)
 {
   for (int j = 0; j < 3; j++)
   {
      if(m1[i][j]%2 == 1)
      {
         System.out.print(m1[i][j]);
      }
      else
      {
         System.out.print(" ");
      }   
   }
 }
 
 System.out.print("\n");
 
 for(int i = 1; i < 2; i++)
 {
   for (int j = 0; j < 3; j++)
   {
      if(m1[i][j]%2 == 1)
      {
         System.out.print(m1[i][j]);
      }
      else
      {
         System.out.print(" ");
      }   
   }
 }
 
 System.out.print("\n");
 
 for(int i = 2; i < 3; i++)
 {
   for (int j = 0; j < 3; j++)
   {
      if(m1[i][j]%2 == 1)
      {
         System.out.print(m1[i][j]);
      }
      else
      {
         System.out.print(" ");
      }   
   }
 }
 
 System.out.println("\nArray 2:");
 for(int i = 0; i < 1; i++)
 {
   for (int j = 0; j < 3; j++)
   {
      if(m2[i][j]%2 == 1)
      {
         System.out.print(m2[i][j]);
      }
      else
      {
         System.out.print(" ");
      }   
   }
 }
 
 System.out.print("\n");
 
 for(int i = 1; i < 2; i++)
 {
   for (int j = 0; j < 3; j++)
   {
      if(m2[i][j]%2 == 1)
      {
         System.out.print(m2[i][j]);
      }
      else
      {
         System.out.print(" ");
      }   
   }
 }
 
 System.out.print("\n");
 
 for(int i = 2; i < 3; i++)
 {
   for (int j = 0; j < 3; j++)
   {
      if(m2[i][j]%2 == 1)
      {
         System.out.print(m2[i][j]);
      }
      else
      {
         System.out.print(" ");
      }   
   }
 }       
        
}

/**
 * Returns true if the two arrays have all numbers satisfying 1 < numbers <= 10 and returns false otherwise
 * @return Depending on whether a number is found in the array will make it return false otherwise check will remain true
 */
 public static boolean silly(int m1[][], int m2[][]) {
 boolean check = true;
 for(int i = 0; i < m1.length; i++)
 {
   for (int j = 0; j < m1.length; j++)
   {
      if((1 >= m1[i][j] || m1[i][j] > 10) || (1 >= m2[i][j] || m2[i][j] > 10))
      {
         check = false;
      }
   }
}
return check;
} 

}