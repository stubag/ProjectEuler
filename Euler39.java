/*
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p <= 1000, is the number of solutions maximised?

*/
import java.util.ArrayList;
import java.lang.Object;
import java.util.HashMap;
import java.util.Map;

public class Euler39
{

double a, b, c;
public int p = 0;
double max, count;


public static void main(String[] args) 
{
 ArrayList<Integer> ps = new ArrayList<>();
for(int x = 1; x < 1001; x++) {
   for(int y = 1; y < 1001; y++) {
      for(int z = 1; z < 1001; z++) {
      
      if ((x+y+z) <= 1001)
      {
         
         if ((Math.pow(x, 2) + Math.pow(y, 2)) == Math.pow(z, 2))
         {
            ps.add(x+y+z);
         }
      }
  }
 }
}  
  
  for (int value : ps) 
  {
   System.out.println(value);
  }
  
Map<Integer, Integer> seussCount = new HashMap<Integer ,Integer>();
    for(Integer t: ps) {
       Integer i = seussCount.get(t);
       if (i ==  null) {
           i = 0;
       }
       seussCount.put(t, i + 1);
    }
  
  System.out.println(seussCount);
}
}

// ths is definitely one of my worst Euler programs