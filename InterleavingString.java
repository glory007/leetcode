// SOLVED ! both small and large cases
// but after several times of tryings. 

// for dynamic programming questions, first think clearly about what is the state transition look like, and what is the meaning of the state.

import java.util.HashSet;
import java.util.Set;

/*
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 */


//http://www.careercup.com/question?id=2571
public class InterleavingString {
	
    public static boolean isInterleave3(String s1, String s2, String s3) {
		
    	if(s3.length() != s1.length() + s2.length())
		    return false;
    	
		boolean[][] r = new boolean[s1.length()+1][s2.length()+1];
    	r[0][0] = true;
    	
    	for(int j = 1; j < s2.length() + 1; j++ ){
		    r[0][j] = r[0][j-1] && (s3.charAt(j-1) == s2.charAt(j-1));
    	}

    	for(int i = 1; i < s1.length() + 1; i++ ){
			r[i][0] = r[i-1][0] && (s3.charAt(i-1) == s1.charAt(i-1));
    	}
    	
    	for(int i = 1; i < s1.length()+1; i++){
    		for(int j = 1; j < s2.length()+1; j++){
    			r[i][j] = (s3.charAt(i+j-1)== s1.charAt(i-1) && r[i-1][j]) 
    					|| (s3.charAt(i+j-1)== s2.charAt(j-1) && r[i][j-1]);
    		}
    	}
    	return r[s1.length()][s2.length()];
    }
	
	public static void main(String[] args){
		System.out.println(isInterleave3("a","b","ac"));
	}
	

	// DP
	
	public static boolean isInterleave2(String s1, String s2, String s3){
		if(s3.length() != s1.length() + s2.length())
			return false;
		if(s1.length() < s2.length()){
			int[][] r = LCS(s3,s1);
			Set<String> s = getDiff(s3,s1,r,s3.length()-1,s1.length()-1);
			if(s.contains(s2)){
				return true;
			}
		}
		else{
			int[][] r = LCS(s3,s2);
			Set<String> s = getDiff(s3,s2,r,s3.length()-1,s2.length()-1);
			if(s.contains(s1)){
				return true;
			}
		}
		return false;
	}
	
	// assume input s2 is a subsequence of input s1
	public static Set<String> getDiff(String s1, String s2, int[][] r, int i, int j){
		if(j<0){
			Set<String> tmp = new HashSet<String>();
			tmp.add(s1.substring(0,i+1));
			return tmp;
		}
		
		Set<String> s = new HashSet<String>();
		
		if(s1.charAt(i) == s2.charAt(j)){
			Set<String> tmp1 = getDiff(s1,s2,r,i-1,j-1);
			s.addAll(tmp1);
		}
		
		if(r[i+1][j+1] == r[i][j+1]){
			Set<String> tmp2 = getDiff(s1,s2,r,i-1,j);
			Set<String> tmp3 = new HashSet<String>();
			for(String x : tmp2){
				tmp3.add(x+s1.charAt(i));
			}
			s.addAll(tmp3);
		}
		if (r[i+1][j+1] == r[i+1][j]){
			Set<String> tmp4 = getDiff(s1,s2,r,i,j-1);
			Set<String> tmp5 = new HashSet<String>();
			for(String x : tmp4){
				tmp5.add(x+s2.charAt(j));
			}
			s.addAll(tmp5);
		}
		
		return s;
	}
	
	
	public static int[][] LCS(String s1, String s2){
		int[][] r = new int[s1.length()+1][s2.length()+1];
		
		for(int i = 0; i < s1.length()+1; i++){
			r[i][0] = 0;
		}
		for(int i = 0; i < s2.length()+1;i++){
			r[0][i] = 0;
		}
		
		for(int i =1; i < s1.length()+1; i++){
			for(int j =1; j < s2.length()+1; j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					r[i][j] = r[i-1][j-1] + 1;
				}
				else{
					r[i][j] = r[i-1][j] > r[i][j-1] ? r[i-1][j] : r[i][j-1];
				}
			}
		}
		return r;
	}
	
	// brute force way, worst case: O(2^N)
	public static boolean isInterleave(String s1, String s2, String s3) {
		
		if(s3.length() != s1.length() + s2.length())
			return false;
		
		return isInterleaveHelper(s1,0,s1.length()-1,s2,0,s2.length()-1,s3,0,s3.length()-1);
    }
	
	
	public static boolean isInterleaveHelper(String s1, int i1, int i2, String s2, int j1, int j2, String s3, int k1, int k2) {
		if(i1 > i2){
			return s2.substring(j1, j2+1).equals(s3.substring(k1,k2+1));
		}
		if(j1 > j2){
			return s1.substring(i1, i2+1).equals(s3.substring(k1,k2+1));
		}
		
		if(s3.charAt(k1) == s1.charAt(i1)){
			boolean tmp = isInterleaveHelper(s1, i1+1,i2, s2, j1, j2, s3, k1+1,k2);
			if(tmp) 
				return true;
		}
		if(s3.charAt(k1) == s2.charAt(j1)){
			boolean tmp = isInterleaveHelper(s1, i1,i2, s2, j1+1, j2, s3, k1+1,k2);
			if(tmp) 
				return true;
		}
		return false;
    }
}
