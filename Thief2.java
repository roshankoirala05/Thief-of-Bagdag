/** Roshan Koirala
    Dr. Cordova
    CSCI 4065
    04/02/2016
    Homework 7
    
    Program Description - Program to compute a 95% confidence interval for the expected value
                          of the average time to freedom - Thief of Bagdag version 2

*/

import java.util.*;


/**
   Program to compute a 95% confidence interval for the expected value
   of the average time to freedom - Thief of Bagdag version 2
*/
public class Thief2 
{
   
   
   
 /**
   Main method to initialize the  times array and calculate the Mean, Standard deviation,
   and 95% confidence interval for the times
 */
   public static void main (String [] args) 
   {
      final int n = 10500;
      
      int[] times = new int[n];
      
      // initializing the times array
      for (int i = 0; i < n; ++i)
      {
         
         times[i] = getSample(); 
      }
      
      
      double sMean = StdStats.mean(times);  // Calculates mean of the sample times
      double stdDev = StdStats.stddev(times); // Calculates standard deviation of the sample times
      
      System.out.printf("After %d replications: mean = %4.2f, std dev = %4.2f\n", n, sMean, stdDev);
      
      // Displaying the 95 % confidence interval
      System.out.printf("95 pct confidence Interval: %4.2f +/- %4.2f\n", sMean, 1.96 * stdDev/Math.sqrt(n));
   }

/**
   Computes a sample from uniformly distributed random fraction in the range 0..1 using recursion
   @return a sample of the  probability distribution
*/    
   public static int getSample()
   {
      double rn = Math.random(); // generates a random number between 0 and 1
      
      int sample;
      
      
      if (rn <= 0.2)     // probability to door to freedom 
         sample = 0;
      
      else if (rn <= 0.55)   // probability to the freedom through short tunnel
         sample = 4 + getSample();
      
      else                   // probability to the freedom through long tunnel
         sample = 7 + getSample();  
      
      return sample;
   }

} // End of class

