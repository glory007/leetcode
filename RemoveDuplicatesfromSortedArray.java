// solved! both small and large cases.

/*
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
    	
    	if (A.length==0) return 0; // empty array
    	
    	int cur_idx = 0;
    	
    	for(int i = 1; i < A.length; i++){
    		if(A[i] != A[cur_idx]){
    			cur_idx++;
    			A[cur_idx] = A[i];
    		}
    	}
    	
    	return cur_idx+1;
    }
}
