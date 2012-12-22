// solved! both small and large cases.

// worst time run time: O(N)

/*
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
Write a function to determine if a given target is in the array.
 */
public class SearchinRotatedSortedArrayII {
	
	   public static boolean search(int[] A, int target) {
	    	int s = 0;
	    	int e = A.length - 1;
	    	
	    	while(s <= e){
	    		int m = (s + e) / 2;
	    		if(A[m] == target) return true;
	    		
	    		if( A[m] > A[s] ){
	    			if(target >= A[s] && target < A[m]){
	    				e = m - 1;
	    			}
	    			else{
	    				s = m + 1;
	    			}
	    		}
	    		else if(A[m] < A[s] ){
	    			if(target > A[m] && target <= A[e]){
	    				s = m + 1;
	    			}
	    			else{
	    				e = m - 1;
	    			}
	    		}
	    		else{
	    			s++;
	    		}
	    	}
	    	return false;
	    }
 
}
