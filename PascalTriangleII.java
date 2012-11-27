import java.util.ArrayList;

/*
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangleII {
	
    public ArrayList<Integer> getRow(int rowIndex) {
    	
    	ArrayList<Integer> r = new ArrayList<Integer>();    		
    	r.add(1);

    	for(int i = 1; i <= rowIndex; i++ ){
        	ArrayList<Integer> r2 = new ArrayList<Integer>();   
        	r2.add(1);
        	for (int k = 1; k < r.size(); k++){
        		r2.add( r.get(k) + r.get(k-1) );
        	}
        	r2.add(1);
        	r = r2;
    	}
    	return r;
        
    }

}
