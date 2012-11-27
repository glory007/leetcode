// SOLVED. BOTH SMALL AND LARGE CASES

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.
Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, É ,ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 */

public class CombinationSum {
	public static void main(String[] args){
		int[] cand = {2,2,3,6,7};
		int target = 2;
		
		ArrayList<ArrayList<Integer>> r = new CombinationSum().combinationSum(cand, target);
		
		for(ArrayList<Integer> a : r){
			for(Integer b : a){
				System.out.print(b + " ");
			}
			System.out.print("\n");
		}
	}
	
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	if(candidates==null || candidates.length==0)
    		return new ArrayList<ArrayList<Integer>>();
    	HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new 
    	    	HashMap<Integer, ArrayList<ArrayList<Integer>>>();
    	
    	for(int i = 1; i <= target; i++){
    		ArrayList<ArrayList<Integer>> v = new ArrayList<ArrayList<Integer>>();
    		
    		for(int j = 0; j < candidates.length; j++){
    			if(i == candidates[j]){
    				ArrayList<Integer> temp = new ArrayList<Integer>();
    				temp.add(i);
    				v.add(temp);
    			}
    			
    			else if (i > candidates[j]){
    				int prev_num = i - candidates[j];
    				ArrayList<ArrayList<Integer>> prev = map.get(prev_num);
    				if(prev != null){
    					for(ArrayList<Integer> list : prev){
    						if(list.get(list.size()-1) <= candidates[j] ){
    							ArrayList<Integer> new_list = new ArrayList<Integer>(list);
        						new_list.add(candidates[j]);
        						v.add(new_list);
    						}
    					}
    				}
    			}
    		}
    		
    		if(v.size() > 0){
    			map.put(i, v);
    		}
    	}
        if(map.get(target) == null)
        	return new ArrayList<ArrayList<Integer>>();
        
		return map.get(target);
        
    }
}