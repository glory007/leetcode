// SOLVED! BOTH SMALL AND LARGE CASES!

import java.util.Arrays;

public class PlusOne {
	public static void main(String[] a){
		int[] d = new int[]{0};
		int[] r = plusOne(d);
		for(int x : r){
			System.out.println(x);
		}
	}
	
    public static  int[] plusOne(int[] digits) {
        if (digits.length==0) return digits;
        
        int[] result = new int[digits.length+1];
        
        int carry = 1;
        for(int i = digits.length-1,j=digits.length; i>=0; i--){
            result[j--] =  (digits[i] + carry)%10;
            carry = ( digits[i] + carry ) / 10; 
        }
        
        if (carry == 1){
        	result[0] = 1;
        	return result;
        }
            
       return Arrays.copyOfRange(result, 1, result.length);
        
    }
}