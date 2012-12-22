// solved! both small and large cases.

/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

public class UniqueBinarySearchTrees {
	
	public int numTrees(int n) {
		return (int) catalan(n,n, new long[n+1][n+1]);
	}
	
	public static void main(String [] args){
		long now = System.currentTimeMillis();
		long[][] result = new long[15][15];
		System.out.println(catalan(14,14, result ));
		long now2 = System.currentTimeMillis(); 
		System.out.println(now2-now);
	}

	// used DP to speed up.
	public static long catalan(int x_remaining, int y_remaining, long[][] result){
		if(x_remaining==0 || y_remaining==0){
			return 1;
		}
		
		if(result[x_remaining][y_remaining] != 0){
			return result[x_remaining][y_remaining] ;
		}

		long r = 0;
		if(x_remaining < y_remaining){
			r+=catalan(x_remaining, y_remaining-1, result);
		}
		r+=catalan(x_remaining-1, y_remaining, result);
		result[x_remaining][y_remaining] = r;
		return r;
	}

}
