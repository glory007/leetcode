// passed! both small and large cases! 

// naive brute-force way though.

/*
 * Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.

 */
public class strStrSolution {
	
    public String strStr(String haystack, String needle) {
    	
    	if(needle== null || needle.equals(""))
    		return haystack;
    	
    	if(haystack == null || haystack.equals("")){
    		return null;
    	}
    	
    	for(int  i =0; i <= haystack.length() - needle.length(); i++){
    		int j = 0;
    		for(; j < needle.length(); j++){
    			if(needle.charAt(j)!= haystack.charAt(i+j)){
    				break;
    			}
    		}
    		
    		if(j == needle.length()){
    			return haystack.substring(i);
    		}
    	}
    	
    	return null;
        
    }

}
