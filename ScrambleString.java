// solved - both small and large cases.

import java.util.HashMap;
import java.util.Map;

/*
 * Scramble String
Given a string s1, we may represent it as a binary tree by partitioning 
it to two non-empty substrings recursively. To scramble the string,
we may choose any non-leaf node and swap its two children. Given two 
strings s1 and s2 of the same length, determine if s2 is a scrambled string 
of s1.

https://www.facebook.com/LeetCode/posts/401925436505568

 */
public class ScrambleString {
	
	static class Pair{
		String a;
		String b;
		
		public Pair(String a, String b){
			this.a=a;
			this.b=b;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((a == null) ? 0 : a.hashCode());
			result = prime * result + ((b == null) ? 0 : b.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (a == null) {
				if (other.a != null)
					return false;
			} else if (!a.equals(other.a))
				return false;
			if (b == null) {
				if (other.b != null)
					return false;
			} else if (!b.equals(other.b))
				return false;
			return true;
		}

	}
	
	public static void main(String[] args){
		isScramble("abcdefghijklmnopq","efghijklmnopqcadb");
	}
	
	// Top down DP.
	static Map<Pair, Boolean> map = new HashMap<Pair, Boolean>();

	public static boolean isScramble(String s1, String s2){
		
		if(map.containsKey(new Pair(s1,s2))){
			return map.get(new Pair(s1,s2));
		}
		
		if(s1.length() != s2.length()){
			return false;
		}
		
		if(s1.equals(s2)) 
			return true;
		
		for(int i = 1; i < s1.length() ; i++){
			if( isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))){
				map.put(new Pair(s1,s2), true);
				return true;
			}
			if( isScramble(s1.substring(0,i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length()-i)) ){
				map.put(new Pair(s1,s2), true);
				return true;
			}
				
		}
		map.put(new Pair(s1,s2), false);
		return false;
	}

}
