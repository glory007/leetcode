// solved! both small and large cases.

/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {

    	int row = n;
    	if (row == 0) return new int[0][0];
    	int col = n;
    	
    	int[][] matrix = new int[row][col];
    	
    	int x = 0;
    	int y = 0;
    	int count = 1;
    	while(row > 0 && col > 0){
    		for(int i = y; i < y + col; i++){
    			matrix[x][i] = count++;
    		}
    		
    		for(int i = x+1; i < x + row; i++){
    			matrix[i][y+col-1]=count++;
    		}
    		
    		if(row>1){
    			for(int i = y + col - 2; i >=y; i--){
        			matrix[x+row-1][i]=count++;
        		}	
    		}
    		if(col>1){
    			for(int i = x + row - 2; i > x; i-- ){
    				matrix[i][y]=count++;
    			}
    		}
    		x++;
    		y++;
    		row-=2;
    		col-=2;
    	}
    	return matrix;
    }
	

}
