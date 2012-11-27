// SOLVED! (both small and large cases!)

// NOTE:
// BE CAREFUL OF ZEROES!

/*
Decode Ways
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/
import java.util.HashMap;
public class DecodeWays {
	
	
	public static void main(String[] args){
		String s = "230";
		System.out.println(numDecodings(s));
	}
	
    public static int numDecodings(String s) {
        if(s==null || s.equals("")) 
            return 0;
        
        return numDecodingsHelper(s,0, new HashMap<String, Integer>());
    }
    
    public static int numDecodingsHelper(String s, int start, HashMap<String, Integer> map){
    	
    	if(s.charAt(start)=='0') return 0;

    	if(start >= s.length()-1){
            return 1;
        }

        int total = 0;
        for(int i = 1; i <=2; i++){
            if(Integer.parseInt (s.substring(start, start+i))<=26){
            	int count = 0;
            	if(start+i < s.length()){
            		String subString1 = s.substring(start+i, s.length());
            		count = map.containsKey(subString1) ? 
            				map.get(subString1) : numDecodingsHelper(s, start+i, map);
            	}
            	else{
            		count=1;
            	}
                total = total + count;
            }
        }
        
        map.put(s.substring(start, s.length()), total);
        return total;
    }
}