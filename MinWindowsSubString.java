import java.util.HashMap;
import java.util.Map;

// http://www.leetcode.com/2010/11/finding-minimum-window-in-s-which.html

/*
 * Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinWindowsSubString {

	
	public static void main(String[] args){
		String S= "acbbaca";
		String T = "aba";
		
		System.out.println(minWindow(S,T));
		
	}

	public static void putInMap(Map<Character, Integer> map, Character c){
		if(map.containsKey(c)){
			map.put(c, map.get(c)+1);
		}
		else{
			map.put(c, 1);
		}
	}
	
	public static  String minWindow(String S, String T) {
		
		HashMap<Character, Integer> needToFound = new HashMap<Character, Integer>();

		// init the needToFound map.
		for(int i = 0; i < T.length(); i++){
			putInMap(needToFound, T.charAt(i));
		}
		
		HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
		
		int count = 0;
		
		int curr_min = Integer.MAX_VALUE;
		int curr_begin = -1;
		
		for (int i = 0,j = 0; j < S.length(); j++){
			if(needToFound.containsKey(S.charAt(j))){
				putInMap(hasFound, S.charAt(j));
				
				if(hasFound.get(S.charAt(j)) <= needToFound.get(S.charAt(j))){
					count++;
				}
				
				if(count == T.length()){
					while(!needToFound.containsKey(S.charAt(i)) || hasFound.get(S.charAt(i)) > needToFound.get(S.charAt(i))){
						if(hasFound.containsKey(S.charAt(i))){
							hasFound.put(S.charAt(i), hasFound.get(S.charAt(i))-1);
						}
						i++;
					}
					
					if(curr_min > j-i){
						curr_min = j-i;
						curr_begin = i;
					}
				}
			}
			
		}
       
		return S.substring(curr_begin, curr_begin+curr_min+1);
        
    }
}
