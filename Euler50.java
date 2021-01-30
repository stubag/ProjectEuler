/*
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?

*/

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;

public class Euler50
{
   public static ArrayList<Integer> primes = new ArrayList<Integer>();
   public static ArrayList<Integer> totals = new ArrayList<Integer>();
   public static int max = 0;
   public static int total = 0;
   public static void main(String[] args)
   {
   
      primes.add(2);
      int count = 0;
      int consecutive = 0;
      int finalmax =0;
      int newconsec = 0;
      int newfinalmax = 0;
      for (int i = 3; i < 1000000; i++)
      {
            if (isPrime(i))
            {
               primes.add(i);
            }
      }
      
      for (int i = 0; i < primes.size(); i++)
      {           
         //System.out.println("Starting Prime: " + primes.get(i));
         for (int b = i; b < primes.size(); b++)
         {
               count += 1;
               total += primes.get(b);
               if (primes.contains(total))
               {                  
                                   
                  max = total;
                  if (max > finalmax)
                  {
                     finalmax = max;
                     consecutive = count;
                  }
               
                  
               }
               if (total > 1000000)
               {
                  b = primes.size();
               }
               
          }
               if (consecutive > newconsec)
               {
               System.out.println("Consecutive Primes: " + consecutive);
               System.out.println("Prime sum: " + finalmax);
               newconsec = consecutive;
               newfinalmax = finalmax;
               }
               total = 0;
               count = 0;
          }
                                
   }
   
   
   
   
    public static boolean isPrime(int n)
    {
    //check if n is a multiple of 2
    if (n%2==0)
    {
       return false;
    }
    //if not, then just check the odds
    for(int i=3;i*i<=n;i+=2)
    {
        if(n%i==0)
            return false;
    }
    return true;
    }

}
