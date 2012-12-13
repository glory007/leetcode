// solved! both small and large cases.

import java.util.ArrayList;
import java.util.HashSet;
/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
 */
public class PermutationsII {

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {

    	return permuteUnique(num, 0, num.length-1);
    }
	
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num, int s, int e) {
    	ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
    	
    	if(s==e){
    		ArrayList<Integer> r1 = new ArrayList<Integer>();
    		r1.add(num[s]);
    		r.add(r1);
    		return r;
    	}
    	
    	HashSet<Integer> set = new HashSet<Integer>();
    	
    	for(int i = s; i <=e ; i++){
    		if(!set.contains(num[i])){
    			set.add(num[i]);
    			swap(num, s, i);
    			ArrayList<ArrayList<Integer>> x = permuteUnique(num, s+1, e);
    			for(ArrayList<Integer> a : x){
    				a.add(num[s]);
    				r.add(a);
    			}
    			swap(num, s, i);
    		}
    	}
    	return r;
    }
    
    public static void swap(int[] num, int i, int j){
    	int t = num[i];
    	num[i] = num[j];
    	num[j] = t;
    }
}

