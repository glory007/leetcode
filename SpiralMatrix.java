// solved! both small and large cases! be careful of edge cases, such as M*1 or 1*N matrix...

import java.util.ArrayList;

/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	
    	int row = matrix.length;
    	if (row == 0) return res;
    	int col = matrix[0].length;
    	
    	int r = row;
    	int c = col;
    	
    	int x = 0;
    	int y = 0;
    	
    	while(r > 0 && c > 0){
    		for(int i = y; i < y + c; i++){
    			res.add(matrix[x][i]);
    		}
    		
    		for(int i = x+1; i < x + r; i++){
    			res.add(matrix[i][y+c-1]);
    		}
    		if(r>1){
    			for(int i = y + c - 2; i >=y; i--){
        			res.add(matrix[x+r-1][i]);
        		}	
    		}
    		if(c>1){
    			for(int i = x + r - 2; i > x; i-- ){
    				res.add(matrix[i][y]);
    			}
    		}
    		x++;
    		y++;
    		r-=2;
    		c-=2;
    	}
    	return res;
    }

}
