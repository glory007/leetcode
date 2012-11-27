// solved! both small and large cases.

// but codes are messy. any better ways to code this up?

/*
 * Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
 */

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
public class IntegerToRoman {
    public String intToRoman(int num) {
    	if(num == 0) return "";
    	
    	if(num >=1000){
    		String r = "";
    		for(int i = 0; i < num / 1000; i++ ){
    			r = r + "M";
    		}
    		return r + intToRoman(num%1000);
    	}
    	if(num >= 900){
    		return "CM" + intToRoman(num - 900);
    	}
    	
    	if(num >= 500){
    		return "D" + intToRoman(num - 500);
    	}
    	
    	if(num >=400){
    		return "CD" + intToRoman(num - 400);
    	}
    		
    	if(num>=100){
    		String r = "";
    		for(int i = 0; i < num / 100; i++ ){
    			r = r + "C";
    		}
    		return r + intToRoman(num%100);
    	}
    		  
    	if(num >= 90){
    		return "XC" + intToRoman(num - 90);
    	}	
    	
    	if(num >= 50){
    		return "L" + intToRoman(num - 50);
    	}
    	
    	if(num >= 40){
    		return "XL" + intToRoman(num - 40);
    	}
    	
    	if(num>=10){
    		String r = "";
    		for(int i = 0; i < num / 10; i++ ){
    			r = r + "X";
    		}
    		return r + intToRoman(num%10);
    	}
    	
    	if(num >= 9){
    		return "IX" + intToRoman(num - 9);
    	}	
    	if(num >= 5){
    		return "V" + intToRoman(num - 5);
    	}
    	if(num >= 4){
    		return "IV" + intToRoman(num - 4);
    	}
    	if(num>=1){
    		String r = "";
    		for(int i = 0; i < num ; i++ ){
    			r = r + "I";
    		}
    		return r;
    	}
		return null;
    }

}
