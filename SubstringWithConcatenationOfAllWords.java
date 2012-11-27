// SOLVED ! BOTH SMALL AND LARGE PASSED! (on a 2nd try....)

import java.util.ArrayList;
import java.util.HashMap;

/*
 * You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation of each word in L 
 * exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 */

public class SubstringWithConcatenationOfAllWords {
	
	public static void main(String[] arg){
		ArrayList<Integer> a = findSubstring("barfoothefoobarman",new String[] {"foo", "bar"});
		for(Integer x : a){
			System.out.println(x);
		}
	}
	
   public static ArrayList<Integer> findSubstring(String S, String[] L) {
   
	   ArrayList<Integer> result = new ArrayList<Integer>();
       int l = L[0].length()*L.length;
   
       int step = L[0].length();
       
       HashMap<String, Integer> map = new HashMap<String, Integer>();
       for(String x : L){
	       if(map.containsKey(x)){
	          map.put(x, map.get(x)+1);
	       }
	       else{
	          map.put(x,1);
	       }
	    }
       
       for(int i = 0; i<= S.length()-l; i++){
    	   HashMap<String, Integer> map2 = new HashMap<String, Integer>();
    	   int count = 0;
    	   for(int j =i; j <= i+l-1; j = j+ step){
    		   String d = S.substring(j, j+step);
    		   if(!map.containsKey(d)){
    			   break;
    		   }
    		   else{
    			   if(map2.containsKey(d)){
    				   map2.put(d, map2.get(d)+1);
    			   }
    			   else{
    				   map2.put(d, 1);
    			   }
    			   if(map2.get(d) > map.get(d)){
    				   break;
    			   }
    			   count++;
    		   }
    	   }

    	   if(count == L.length){
    		   result.add(i);
    	   }
       }
       
   	return result;
   	
   }

}
