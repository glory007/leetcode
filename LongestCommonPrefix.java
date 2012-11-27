// solved! both small and large cases.

/*
 * Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.
 */

public class LongestCommonPrefix {
	
    public static String longestCommonPrefix(String[] strs) {
    	
    	if(strs.length == 0) return "";
    	if(strs.length == 1) return strs[0];
    	
    	boolean f = false;
    	int i = 0;
    	while(i < strs[0].length()){
    		for(int j = 1; j < strs.length; j++){
    			if(i == strs[j].length()){
    				f=true;
    				break;
    			}
    			
    			if(strs[j].charAt(i) != strs[0].charAt(i)){
    				f=true;
    				break;
    			}
    		}
    		
    		if(f) break;
    		i++;
    		
    	}
    	return strs[0].substring(0,i);
    }
    


}
