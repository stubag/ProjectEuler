/*We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
*/ 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.io.*;

public class Euler41
{
   public static boolean prime = false;
   public static ArrayList<Integer> primes = new ArrayList<Integer>();
   public static ArrayList<Integer> pandigi = new ArrayList<Integer>();
   

   public static void main(String[] args)
   {
      for (int i = 0; i < 999999999; i++)
      {
         isPanDigi(i);
      }
      System.out.println(primes.get(primes.size()-1));
         
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
   
   public static boolean isPanDigi(int n)
   {
      boolean pandigi = false;
      String pan = String.valueOf(n);
      int panlength = 0;
      String[] pansplit = pan.split("");
      ArrayList<Integer> panint = new ArrayList();
      for (int i = 0; i < pansplit.length; i++)
      {
         panint.add(Integer.parseInt(pansplit[i]));  
                     
      }
      
      Collections.sort(panint);
      int a = 1;
      for (int i = 0; i < panint.size(); i++)
      {
         if (panint.get(i) == a)
         {
            
            pandigi = true;            
            //System.out.println(n + " for " + a + " case is currently true");
            a++;
         }
         else if (panint.get(i) != a)
         {
            pandigi = false;
            i = panint.size();
            //System.out.println(n + " is not a pandigi");
         }
         
               
      }
      if (pandigi == true)
      {
         if (isPrime(n) == true)
         {
            primes.add(n);
            System.out.println(n + " is a pandigi and a prime number");
         }
         
       
      }      
      return pandigi;
   }
}