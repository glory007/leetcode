// PASSED! both small and large cases (on first try!)


/*
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 */


// Dynamic programming
public class DistinctSubsequences {
	
	public static void main(String[] args){
		String s = "rabbbit";
		String t = "rabit";
		System.out.print(numDistinct(s,t));
	}
	
    public static int numDistinct(String S, String T) {
    	int m = S.length();
    	int n = T.length();
    	
    	if(n==0) return 1;
        if(m<n) return 0;
        
    	int[][] result = new int[m][n+1];
    	
    	// init
    	for(int i = 0; i < m; i ++){
    		result[i][0] = 1;
    	}
    	
    	result[0][1] = S.charAt(0)==T.charAt(0) ? 1 : 0;
    	
    	for(int i = 2; i < n+1; i++){
    		result[0][i] = 0;
    	}
    	
    	for(int i = 1; i < m; i++){
    		for(int j = 1; j <= i+1; j++){
				if(S.charAt(i) == T.charAt(j-1)){
    				result[i][j] = result[i-1][j-1] + result[i-1][j];
    			}
    			else{
    				result[i][j] = result[i-1][j];
    			}
    		}
    	}
    	return result[m-1][n];
    }
}
