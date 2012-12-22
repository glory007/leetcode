// solved, small and large case passed.

import java.util.TreeSet;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */
public class JumpGame {
	/*
	 * running time : O(n*logn)
	 */
	public static boolean canJump(int[] A) {
		
		boolean[] canJump = new boolean[A.length];
		TreeSet<Integer> set = new TreeSet<Integer>();
		canJump[A.length-1] = true;
		set.add(A.length-1);
		
		for(int i = A.length-2; i>=0; i--){
			
			if(set.subSet(i, i+A[i]+1).size()!=0){
				canJump[i] = true;
				set.add(i);
			}
		}
		
		return canJump[0];
	}
	

}
