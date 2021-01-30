/*
The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?

*/
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;


public class Euler42
{
   public static ArrayList<Double> triangles = new ArrayList<Double>();

   public static void main(String[] args)
   {
      int total = 0;
      for (double z = 1; z < 27; z++)
      {
         double triangle = ((0.5)*z)*(z+1);
         //System.out.println(triangle);
         triangles.add(triangle);
      }
         
      HashMap<Integer,String> hm=new HashMap<Integer,String>();
      int a = 1;
      for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++)
      {
         String alpha = String.valueOf(alphabet);
         hm.put(a, alpha);
         a++;
      }   
         //System.out.println(hm);
   
      File file = new File("p042_words.txt"); 
      try
      {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String st;
      st = br.readLine();
      String[] split = st.split(",");
      double value = 0;
      
      boolean tof = false;
      for (int i = 0; i < split.length; i++)
      {
         split[i] = split[i].replace("\"", "");
            
      }
      for (int i = 0; i < split.length; i++)
      {
         String[] wordsplit = split[i].split("");
         for (int c = 0; c < wordsplit.length; c++)
            {
                value += getKeyFromValue(hm, wordsplit[c]);
                //System.out.println(getKeyFromValue(hm, wordsplit[c]) + " is letter " + wordsplit[c]);
            } 
            //System.out.println(split[i] + " has a total value of " + value);
            tof = isTriangle(triangles, value);
            if (tof == true)
            {
               total++;
            }
            tof = false;               
            value = 0;
      }
      }
      catch (IOException e)
      {
         System.out.println("#failure");
      }
      System.out.println("Total triangle words are " + total);
      
  }
  
  
  public static int getKeyFromValue(Map hm, Object value)
  {
    for (Object o : hm.keySet())
    {
      if (hm.get(o).equals(value))
      {
        String newo = String.valueOf(o);
        int numo = Integer.parseInt(newo);
        return numo;
      }
    }
    return 0;
  }
  
  public static boolean isTriangle(ArrayList<Double> tri, double value)
  {
     //System.out.println(value);
     //System.out.println(tri);
     if (tri.contains(value))
     { 
        
      return true;
     }
     return false;
  }
}

 