// SOLVED! both small and large cases.

/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings {
	public static void main(String[] args){
		System.out.println(multiply("2344","2"));
	}

	/*
	 * implementations of Karatsuba algorithm
	 * 
	 * BUG - something is wrong with the implementations - need to debug.
	 */
	public static String multiply(String a, String b){
		if(a.equals("") || b.equals("")) return "0";
		
		if(a.length() == 1 && b.length() == 1){
			return Integer.toString( (Integer.parseInt(a) * Integer.parseInt(b)) );
		}
		int l = a.length() > b.length() ? b.length() : a.length();
		int n = l / 2 > 0 ? l /2 :1 ;

		
		String z2 = multiply(a.substring(0, a.length() - n), b.substring(0, b.length()-n));
		String z0 = multiply(a.substring(a.length()-n), b.substring(b.length()-n));
		String m = multiply( add(a.substring(0, a.length() - n), a.substring(a.length() - n)),
				add(b.substring(0, b.length() - n), b.substring(b.length() - n)));
		
		String z1 = minus ( minus( multiply( add(a.substring(0, a.length() - n), a.substring(a.length() - n)),
				add(b.substring(0, b.length() - n), b.substring(b.length() - n)) ) , z0) , z2);
		
		return add(add( z2 + padding(2*n), z0), z1 +padding(n));
	}
	
	// passed! both small and large cases.
	public static String multiply3(String a, String b){
		if(a.length() > b.length() ) return multiply(b,a);
		if(a.equals("") || b.equals("")) return "0";
		
		if(a.charAt(0)=='0') return multiply(a.substring(1),b);
		if(b.charAt(0)=='0') return multiply(b.substring(1),a);
		int n = a.charAt(0)-'0';
		int c = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = b.length()-1; i>=0;i--){
			int v = ( n * (b.charAt(i)-'0') + c ) % 10;
			sb.append(v);
			c = ( n * (b.charAt(i)-'0') + c ) / 10;
		}
		if(c!=0) sb.append(c);
		return add(multiply(a.substring(1), b) , 
				sb.reverse().toString() + padding(a.length()-1));
	}
	
	// assume input string a is always greater than input string b
	public static String minus(String a, String b){
		
		StringBuilder sb= new StringBuilder();
		int m = a.length()-1;
		int n = b.length()-1;
		int c = 0;
		
		for(int i = m ; i >=0; i--){
			int t = n >= 0 ? b.charAt(n) -'0' : 0;
			int x = a.charAt(i)-'0' + c - t;
			if(x>=0){
				sb.append(x);
			}
			else{
				sb.append(10+x);
				c= -1 ;
			}
			n--;
		}
		
		return sb.reverse().toString();
	}
	
	public static String add(String a, String b){
		if(a.length() < b.length() ) return add(b,a);
		StringBuilder sb= new StringBuilder();
		int m = a.length()-1;
		int n = b.length()-1;
		int c = 0;
		while(m>=0){
			int t = n >=0 ? b.charAt(n) -'0' : 0;
			int v = ((a.charAt(m) -'0') + t + c ) %10;
			sb.append(v);
			c = ((a.charAt(m) -'0') + t + c ) / 10;
			m--;n--;
			
		}
		if(c!=0)
		    sb.append(c);
		return sb.reverse().toString();
	}
	
	public static String padding(int n){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++){
			sb.append('0');
		}
		return sb.toString();
	}
	
	public static String multiply2(String a, String b){
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
