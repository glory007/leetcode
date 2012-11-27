// SOLVED. BOTH SMALL AND LARGE CASES (LARGE CASE: 796 ms)

// NEED TO FIGURED OUT A FASTER WAY
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class CombinationSum2 {
	public static void main(String[] args){
		int[] cand = {10,1,2,7,6,1,5};
		int target = 8;
		
		ArrayList<ArrayList<Integer>> r = new CombinationSum2().combinationSum2(cand, target);
		
		for(ArrayList<Integer> a : r){
			for(Integer b : a){
				System.out.print(b + " ");
			}
			System.out.print("\n");
		}
	}
	
	public static int count(ArrayList<Integer> list, int t){
		int  r = 0;
		for(int x : list){
			if(x==t) r++;
		}
		return r;
	}
	
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		
		HashMap<Integer, HashSet<ArrayList<Integer>>> map = new HashMap<Integer, HashSet<ArrayList<Integer>>> ();
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer> ();
		
		for(int x : num){
			int value = count.containsKey(x) ? count.get(x)+1:1;
			count.put(x, value);
		}
		
		return new ArrayList<ArrayList<Integer>>(
				combinationSum2Helper(num, target, count, map)
				);
	}
	

	
    public static HashSet<ArrayList<Integer>> combinationSum2Helper(int[] num, int target,
    		HashMap<Integer, Integer> count, HashMap<Integer, HashSet<ArrayList<Integer>>> map) {
    	
    	if(num==null || num.length==0)
    		return new HashSet<ArrayList<Integer>>();
    	
		HashSet<ArrayList<Integer>> v = new HashSet<ArrayList<Integer>>();
		
    	for(int i = 0; i < num.length; i++){
    		if(target == num[i] ){
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(num[i]);
				v.add(temp);
			}
    		else if(target > num[i]){
    			int new_target = target - num[i];
    			HashSet<ArrayList<Integer>> set = null;
    			if(map.containsKey(new_target)){
    				set = map.get(new_target);
    			}
    			else{
    				set = combinationSum2Helper(num, new_target, count, map);
    			}
    			
    			for(ArrayList<Integer> list : set){
					int c = count(list, num[i]);
					if(list.get(list.size()-1) <= num[i] && c < count.get(num[i])){
						ArrayList<Integer> new_list = new ArrayList<Integer>(list);
						new_list.add(num[i]);
						v.add(new_list);
					}
				}
    			
    		}
    	}
    	
    	if(v.size() > 0){
			map.put(target, v);
		}
        
		return v;
        
    }
}