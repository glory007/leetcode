// solved. both small and large cases.

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */

public class SearchInRotatedSortedArray {
	
	public static void main(String[] args){
		int[] A = new int[]{1};
		System.out.print( search(A,0) );
	}
	
    public static int search(int[] A, int target) {
    	int s = 0;
    	int e = A.length - 1;
    	
    	while(s <= e){
    		int m = (s + e) / 2;
    		if(A[m] == target) return m;
    		
    		if( A[m] >= A[s] ){
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
    	}
    	return -1;
    }
}
