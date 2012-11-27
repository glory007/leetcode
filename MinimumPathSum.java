import java.util.ArrayList;
import java.util.List;
// SOLVED! both small and large cases!
// NEED TO RETEST!
/*
 * Minimum Path Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
	
	// linear space. without changing the input grid value
    public static int minPathSum2(int[][] grid) {
        int m = grid.length;
        if (m==0) return 0;
        int n = grid[0].length;
        if(n==0) return 0;

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(grid[0][0]);
        
        for(int level = 1; level <= m+n-2; level++){
        
        	List<Integer> list2 = new ArrayList<Integer>();
        	
        	int start_row = (level <= n-1) ? 0 : (level - n + 1);
        	int start_col = level - start_row;

        	if(start_row==0){
        	    list2.add(list1.get(0) + grid[start_row++][start_col--]);	
        	}
        	for(int i = 1; i <= list1.size()-1; i++){
        		if(start_row <= m-1 && start_col >= 0){
        			int tmp = (list1.get(i) < list1.get(i-1) ? list1.get(i) : list1.get(i-1)) + grid[start_row++][start_col--];
            		list2.add(tmp);
        		}
        	}
        	// last element
        	if(start_row <= m-1 && start_col >= 0){
        		list2.add( list1.get(list1.size()-1) + grid[start_row][start_col] );
        	}
        	
        	list1= list2;
        }
        
        return list1.get(0);
    }
	
	public static void main(String[] args){
		int[][] grid = { { 1,2},{5,6},
		{1,1}};
		
		System.out.println(minPathSum(grid));
	}
    
    // no extra space, but change the value in the input grid
    public static int minPathSum3(int[][] grid){
    	 int m = grid.length;
         if (m==0) return 0;
         int n = grid[0].length;
         if(n==0) return 0;
         
         for(int i = 1; i <= n-1; i++){
        	 grid[0][i] = grid[0][i-1] + grid[0][i];
         }
         for(int j = 1; j <= m-1; j++){
        	 grid[j][0] = grid[j-1][0] + grid[j][0];
         }
         
         for(int i = 1; i <= m-1; i++){
        	 for(int j=1; j <=n-1; j++){
        		 grid[i][j] = grid[i][j] + (grid[i-1][j] < grid[i][j-1] ? grid[i-1][j]: grid[i][j-1]);
        	 }
         }
         return grid[m-1][n-1];
    }
	
    // Linear space
    public static int minPathSum(int[][] grid) {
        int m = grid.length; // row
        if (m==0) return 0;
        int n = grid[0].length; // column
        if(n==0) return 0;
        
        int[] result = new int[n];
        
        result[0] = grid[0][0];
        for(int i = 1; i < n; i++){
            result[i] = result[i-1]+grid[0][i];
        }
        
        for(int i = 1; i < m; i++){
        	result[0] += grid[i][0];
        	for(int j = 1; j < n; j++){
        		result[j] = result[j-1] < result[j] ? result[j-1] + grid[i][j] : result[j] + grid[i][j]; 
        	}
        }
        return result[n-1];
    }
}
