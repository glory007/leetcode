// SOLVED both small and large cases. but after several try..

// got algo right, but it is very tricky to program. be careful and program slowly for these kind of questions.

import java.util.HashMap;

/*
 * Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	
	public static void main(String[] args){
		
		System.out.print(lengthOfLongestSubstring("abcabcbb"));
		
	}

	// algo: sliding windows
	public static int lengthOfLongestSubstring(String s) {
    	if(s== null || s.length() == 0) return 0;
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	
    	int i = 0; int j = 0;
    	int cur = 1;
    	while(j < s.length()){
    		
    		if(!map.containsKey(s.charAt(j))){
    			map.put(s.charAt(j), 1);
    			cur = (j-i+1) > cur ? j-i+1 : cur;
    		}
    		else{
    			// move i;
    			while(s.charAt(i)!= s.charAt(j)){
    				map.remove(s.charAt(i));
    				i++;
    			}
    			i++;
    			cur = (j-i+1) > cur ? j-i+1 : cur;
    		}
    		j++;
    	}
    	
    	return cur;
    }
}
