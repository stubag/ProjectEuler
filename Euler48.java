/*
The series, 11 + 22 + 33 + ... + 1010 = 10405071317.

Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
*/

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.math.BigInteger;


public class Euler48
{
   public static void main(String[] args)
   {
   BigInteger test = new BigInteger("0");
   BigInteger count = new BigInteger("1");
   BigInteger powers = new BigInteger("0");
   BigInteger total = new BigInteger("0");
   int exponent = 0;
   for (int i = 1; i <= 1000; i++)
   {
      test = test.add(count);
      powers = test.pow(i);
      total = total.add(powers);
      //System.out.println(total);
   }
      System.out.println(total);
   }
} 
  
   