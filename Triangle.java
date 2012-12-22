// passed both small and large cases
import java.util.ArrayList;

/*
 * Triangle
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {
	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>> ();
		
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(2);
		

		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(3);
		a2.add(4);

		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(6);
		a3.add(5);
		a3.add(7);

		ArrayList<Integer> a4 = new ArrayList<Integer>();
		a4.add(4);
		a4.add(1);
		a4.add(8);
		a4.add(3);
		
		triangle.add(a1);
		triangle.add(a2);
		triangle.add(a3);
		triangle.add(a4);
		
		System.out.print(minimumTotal(triangle));
		
	}
	
    public static  int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	int rowCount = triangle.size();
    	if (rowCount ==0) return 0;
    	int columnCount = triangle.get(triangle.size()-1).size();
        if(columnCount==0) return 0;
        
        int[] res = new int[columnCount];
        
        res[0] = triangle.get(0).get(0);
        
        for(int i = 1; i < rowCount; i++){
        	res[triangle.get(i).size()-1] = triangle.get(i).get(triangle.get(i).size()-1) + res[triangle.get(i).size()-2];
        	
            for(int j = triangle.get(i).size()-2; j > 0 ; j--){
                int t = res[j-1] < res[j] ? res[j-1]: res[j];
                res[j] = triangle.get(i).get(j) + t;
            }
        	res[0] = res[0] + triangle.get(i).get(0);
            
        }    	
        
        int min = res[0];
        for(int i = 1 ; i < columnCount; i++){
            if(res[i] < min){
                min = res[i];
            }
        }
    	
    	return min;

    }
	

}
