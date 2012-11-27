// all passed! both small and large cases.

import java.util.HashMap;

/*
 * roman number rules:
 * A number written in Arabic numerals can be broken into digits. For example, 
 * 1903 is composed of 1 (one thousand), 9 (nine hundreds) , 0 (zero tens), and 3 (three units). 
 * To write the Roman numeral, each of the non-zero digits should be treated separately. 
 * In the above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.[6]

The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. 
(They may appear more than three times if they appear non-sequentially, such as XXXIX.) 

"D", "L", and "V" can never be repeated.[7][8]

"I" can be subtracted from "V" and "X" only. 
"X" can be subtracted from "L" and "C" only. 
"C" can be subtracted from "D" and "M" only. 
"V", "L", and "D" can never be subtracted[8]

Only one small-value symbol may be subtracted from any large-value symbol.[9]


I	1
V	5
X	10
L	50
C	100
D	500
M	1,000
 */

public class RomanToInteger {
	
	public static void main(String[] args){
		String s = "IV".substring(2);
		
		if(s.equals(""))
			System.out.print("sss");
		System.out.println(romanToInt("IV"));
	}

    public static int romanToInt(String s) {
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	
    	map.put("M", 1000);
    	map.put("CM", 900);

    	map.put("D", 500);
    	map.put("CD", 400);

    	map.put("C", 100);
    	map.put("XC", 90);
    	
    	map.put("L", 50);
    	map.put("XL", 40);
    	
    	map.put("X", 10);
    	map.put("IX", 9);
    	
    	map.put("V", 5);
    	map.put("IV", 4);
    	
    	map.put("I", 1);
    	
    	if(s== null || s.equals("") )
    		return 0;
    	
    	if(s.length() == 1) return map.get(s);
    	
    	if(map.containsKey(s.substring(0, 2))){
    		int t = map.get(s.substring(0,2));
    		return t + romanToInt(s.substring(2));
    	}
    	return map.get(s.substring(0,1))  + romanToInt(s.substring(1));
    	
    	
    	
        
    }
}
