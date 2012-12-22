// NOT SOLVED! small case not passed!

/*
 * Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */
public class ValidNumber {

	/*
	 * cases did not cover: 00, 2e0, .53, 0.0
	 */
    public boolean isNumber(String s) {
    	
    	s = s.trim();
    	if(s.length() == 0) return false;
    	// first char should be number
    	if( (s.charAt(0)-'0'<0 || s.charAt(0)-'0'>9) && s.charAt(0) != 'e' )
    		return false;
    	
    	// last char should be number as well
    	if( s.charAt(s.length()-1)-'0'<0 || s.charAt(s.length()-1)-'0'>9 )
    		return false;
    	
    	for(int i = 1; i < s.length() - 1; i++){
    		if(s.charAt(i) != 'e' && s.charAt(i) != '.' &&
    				 (s.charAt(i)-'0'<0 || s.charAt(i)-'0'>9) ){
    			return false;
    		}
    	}
    	
    	return true;
    	
        // Start typing your Java solution below
        // DO NOT write main() function
        
    }
    
}
