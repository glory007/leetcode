// solved both small and large cases

/*
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
public class AddBinary {
	
    public String addBinary(String a, String b) {
    	if(a.length() < b.length())
    		return addBinary(b, a);
    	int carry = 0;
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = a.length()-1, j = b.length() - 1; i>=0; i--, j--){
    		int x = a.charAt(i) - '0';
    		int y = j >= 0 ? b.charAt(j) - '0' : 0;
    		sb.append( (x + y + carry) % 2 );
    		carry = (x + y + carry) / 2;
    	}
    	
    	if(carry!=0)
    	    sb.append(carry);
    	
    	return sb.reverse().toString();
    }

}
