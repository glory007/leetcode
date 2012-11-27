import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Subsets II
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class SubsetsII {

	 
	 public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
		 Arrays.sort(S);
		 return subsets(S, 0, S.length - 1);
	 }
	 
	 // assume input array s is sorted
	 public ArrayList<ArrayList<Integer>> subsets(int[] S, int start, int end) {
		 ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
		 if(start > end){
			 ArrayList<Integer> v1 = new ArrayList<Integer>();
			 r.add(v1);
			 return r;
		 }
		 
		 ArrayList<ArrayList<Integer>> temp = subsets(S, start, end - 1);
		 ArrayList<ArrayList<Integer>> temp2 = new ArrayList<ArrayList<Integer>>();
		 
		 for(ArrayList<Integer> x : temp){
			 ArrayList<Integer> y = new ArrayList<Integer>(x);
			 y.add(S[end]);
			 temp2.add(y);
		 }
		 
		 temp.addAll(temp2);
		 
		 //dedup
		 Set<ArrayList<Integer>> s = new HashSet<ArrayList<Integer>>(temp);
		 return new ArrayList<ArrayList<Integer>>(s);
	 }

}
