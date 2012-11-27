// SOLVED! both small and large cases.

/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings {
	public static void main(String[] args){
		System.out.println(multiply("9","9"));
	}

	public static String multiply(String a, String b){
		if(a.equals("0") || b.equals("0")) return "0";
		String prev = "";
		
		for(int i = a.length() - 1 ; i >= 0; i--){
			int x = a.charAt(i) - '0';
			
			StringBuilder cur = new StringBuilder();
			int carry = 0;
			for(int j = b.length() - 1; j >=0 ; j--){
				int y = b.charAt(j) - '0';
				cur.append((x*y+carry) % 10);
				carry = (x*y+carry) / 10;
			}
			if(carry >= 1) cur.append(carry);
			
			StringBuilder tmp = new StringBuilder();
			int offset = a.length() - 1 - i;
			for(int n = 0; n < offset; n++){
				tmp.append(prev.charAt(n));	
			}
			
			int carry2 = 0;
			for(int m = 0; m < cur.length(); m++){
				
				int prev1 = (m+offset) < prev.length() ? prev.charAt(m+offset)-'0' : 0;
				int value = (cur.charAt(m) - '0') + prev1 + carry2;
				tmp.append( value % 10  );
				carry2 = value/10;
			}			
			if (carry2 >= 1) tmp.append(carry2);
			prev = new String(tmp);
			
		}
		return new String(new StringBuilder(prev).reverse());
	}
}
