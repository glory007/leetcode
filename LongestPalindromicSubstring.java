// SOLVED. both small and large cases.

public class LongestPalindromicSubstring {
	
    public String longestPalindrome(String s) {
        if (s.equals("")) return "";
       
        String r = s.substring(0,1);
        for(int i = 1; i < s.length(); i++){
        	String r1 = getLongestPalindrome(s,i,i);
        	if(r1.length() > r.length()){
        		r = r1;
        	}
        	
        	String r2 = getLongestPalindrome(s,i-1,i);
        	if(r2.length() > r.length()){
        		r = r2;
        	}
        }
        
        return r;
    }
    
    public static String getLongestPalindrome(String s, int p1, int p2){
       
    	int l = p1; int r = p2;
    	
    	while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
    		l--;
    		r++;
    	}
    	return s.substring(l+1, r);
    }
}