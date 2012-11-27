import java.util.ArrayList;

/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
		*/
public class PascalTriangle {
	
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();

    	if(numRows==0) return r;
    	if(numRows == 1) {
    		ArrayList<Integer> m = new ArrayList<Integer> ();
    		m.add(1);
    		r.add(m);
    		return r;
    	}
    	
    	r = generate(numRows-1);
		ArrayList<Integer> m = new ArrayList<Integer> ();
		m.add(1);
		
    	for(int i = 1; i < r.get(r.size()-1).size(); i++){
    		m.add(r.get(r.size()-1).get(i)+r.get(r.size()-1).get(i-1));
    	}
    	
		m.add(1);
		
		r.add(m);
		return r;
        
    }

}
