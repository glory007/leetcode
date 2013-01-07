// solved both small and large cases

/*
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] A) {
    	
    	if(A.length == 0) return 0;
    	
    	int cur_idx = 0;
    	int cur_count=1;
    	
    	for(int i = 1 ; i < A.length; i++){
    		if(A[i]!=A[cur_idx]){
    			cur_idx++;
    			A[cur_idx]=A[i];
    			cur_count=1;
    		}
    		else{
    			if(cur_count<2){
    				cur_count++;
    				cur_idx++;
    				A[cur_idx]=A[i]; // be careful here.
    			}
    		}
    	}
    	
    	return cur_idx+1;
        
    }

}
