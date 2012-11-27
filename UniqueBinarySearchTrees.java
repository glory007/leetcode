// solved! both small and large cases.

import java.util.HashMap;

//Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

public class UniqueBinarySearchTrees {
	
	static class Pair{
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + v1;
			result = prime * result + v2;
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
			if (v1 != other.v1)
				return false;
			if (v2 != other.v2)
				return false;
			return true;
		}
		int v1;
		int v2;
		public Pair(int v1, int v2){
			this.v1 = v1;
			this.v2 = v2;
		}
	}
	
	 public int numTrees(int n) {
		return (int) catalan(n,n, new HashMap<Pair, Long> ());
	}
	
	public static void main(String [] args){
		long now = System.currentTimeMillis(); 
		System.out.println(catalan(14,14, new HashMap<Pair, Long> ()));
		long now2 = System.currentTimeMillis(); 
		System.out.println(now2-now);
	}
	
	
	// used DP to speed up.
	public static long catalan(int x_remaining, int y_remaining, HashMap<Pair, Long> map){
		if(x_remaining==0 || y_remaining==0){
			return 1;
		}
		
		Pair p = new Pair(x_remaining, y_remaining);
		
		if(map.containsKey(p))
			return map.get(p);
		
		long result = 0;
		if(x_remaining < y_remaining){
			result+=catalan(x_remaining, y_remaining-1, map);
		}

		result+=catalan(x_remaining-1, y_remaining,map);
		
		map.put(p, result);
		return result;
	}

}
