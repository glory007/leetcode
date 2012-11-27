/*
 * Maximal Rectangle
Given a 2D binary matrix filled with 0's and 1's, 
find the largest rectangle containing all ones and return its area.
 */

// http://www.drdobbs.com/database/the-maximal-rectangle-problem/184410529

public class MaximalRectangle {
	
	public static void main(String[] args){
		char[][] matrix = new char[2][1];
		matrix[0][0] = '1' ;
		matrix[1][0] = '1';
	 
		System.out.println(maximalRectangle(matrix));
	}
	
	// a O(M^2*N^2) solution
    public static int maximalRectangle(char[][] matrix) {
    	
    	if (matrix == null || matrix.length == 0) return 0;
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	int result = 0;
    	
    	// starting point (upper left: i,j)
    	for(int i = 0 ; i < m ; i++){
    		for(int j =0 ; j < n; j++){
    			if(matrix[i][j]=='0') continue;
    			int rightMost = n;
    			// ending point: (lower right: k,p)
    			for(int k = i; k < m; k++){
    				for(int p = j; p <= rightMost; p++){
    					if(p==rightMost || matrix[k][p] == '0' ) {
    						rightMost = p;
        					result = (k-i+1) * (rightMost - j) > result ? (k-i+1) * (rightMost - j) : result;
        					break;
    					}
    				}
    			}
    		}
    	}
    	return result;
    }

}
