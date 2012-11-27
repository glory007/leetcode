/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */
public class JumpGame {
	
	public boolean canJump(int[] A) {
		return canJump(A, 0, A.length - 1);
	}
	
	public boolean canJump(int[] A, int startIndex, int endIndex){
		
		if(startIndex == endIndex)
			return true;
		
		if(endIndex - startIndex == 1){
			if(A[startIndex] > 0){
				return true;
			}
			return false;
		}
		
		for(int j = endIndex - 1; j >= startIndex; j--){
			if(A[j] >= endIndex - j){
				boolean temp = canJump(A, startIndex, j);
				if(temp){
					return true;
				}
			}
		}
		return false;
	}
}
