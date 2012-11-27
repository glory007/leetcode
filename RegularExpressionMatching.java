// solved. small case and large cases passed.

/*
 * Regular Expression Matching
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
	
	public static void main(String[] args){
		System.out.println(isMatch("abbbcd","ab*bbbcd"));
	}
	/*
	 * The recursion mainly breaks down elegantly to the following two cases:

If the next character of p is NOT ‘*’, 
then it must match the current character of s. Continue pattern matching with the next character of both s and p.
If the next character of p is ‘*’, then we do a brute force exhaustive matching of 0, 1, 
or more repeats of current character of p… Until we could not match any more characters.
	 */
    public static boolean isMatch(String s, String p) {
    	
    	if(p.equals(""))
    		return s.equals(p);
    	
    	if(p.length() == 1 && p.equals(".")){
    		return s.length()==1;
    	}
    	
    	if(p.length() == 1){
    		return s.equals(p);
    	}
    	
    	if(p.charAt(1) != '*'){
    		if(s.equals("")) return false;
    		return isMatch(s.substring(0,1), p.substring(0,1)) && isMatch(s.substring(1), p.substring(1));
    	}
    	
    	if(p.charAt(1) == '*'){
    		String p2 = p.substring(2);
    		int i = 0;
    		do{
    			if(isMatch(s.substring(i), p2)){
    				return true;
    			}
    		}while (i < s.length() && (p.charAt(0) == s.charAt(i++) || p.charAt(0)=='.'));
    	}
    	
    	return false;
    	

    }
}
