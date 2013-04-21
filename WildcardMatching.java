/*
 * Wildcard Matching
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ? false
isMatch("aa","aa") ? true
isMatch("aaa","aa") ? false
isMatch("aa", "*") ? true
isMatch("aa", "a*") ? true
isMatch("ab", "?*") ? true
isMatch("aab", "c*a*b") ? false
 */
public class WildcardMatching {
	
	public static void main(String[] args){
		System.out.print(isMatch("a",
				"a**aa***"));
	}
	
	/*
	 * running time: O(M*N), M,N is the length of string s and p.
	 */
	public static  boolean isMatch(String s, String p) {
		// hack for the last large case....
		String p2 = p.replace("*", "");
		if(p2.length() > s.length()) return false;
		
		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;
		
		for(int i = 1; i <= p.length(); i++){
			if (p.charAt(p.length()-i) == '*'){
				for(int k = 1; k < f.length; k++){
					if(f[k-1])
						f[k] = true;
				}
				continue;
			}
			
			for(int j = s.length(); j > 0; j--){
				boolean t = p.charAt(p.length()-i) == '?' ?
						true: p.charAt(p.length()-i) == s.charAt(s.length()-j);
				f[j] = f[j-1] && t;
			}

			f[0] = false;
		}
		return f[f.length-1];
    }
}
