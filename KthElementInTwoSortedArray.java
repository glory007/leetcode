// Given two sorted arrays A, B of size m and n respectively. 
// Find the k-th smallest element in the union of A and B. You can assume that there are no duplicate elements.

public class KthElementInTwoSortedArray {
	
	
	public static void main(String[] arg) throws Exception{
		
		int[] A = {0,2,4,6,8};
		int [] B = {1,3,5,7};
		for(int i = 1; i<=9; i++){
			System.out.print(getKthElement(A,B,i));
		}
	
	}
	
	public static int getKthElement(int[] A, int[] B, int k) throws Exception{
		if(A.length + B.length < k) {
			throw new Exception ("invalid input");
		}
		
		int s = k <= B.length ? 0 : k-B.length-1 ; 
		int e = k - 1 >= A.length  ? A.length-1 : k-1;  
		
		return getKthElementHelper(A,B,k,s,e);
		
	}
	
	public static int getKthElementHelper(int[] A, int[] B, int k, int s, int e){
		if(s>e){
			return getKthElementHelper(B,A, k, k <= A.length ? 0 : k-A.length-1, k - 1 >= B.length  ? B.length-1 : k-1);
		}
		
		int m = (s+e) / 2;
		
		int left = k - m -2;
		int right = k - m - 1;
		
		int low = (left< 0) ? Integer.MIN_VALUE : B[left];
		int high = (right > B.length-1) ? Integer.MAX_VALUE : B[right];
		
		if(A[m] >= low && A[m] <= high) {
			return A[m];
		}
		else if (A[m] > high){
			return getKthElementHelper(A,B,k,s,m-1);
		}
		else {
			return getKthElementHelper(A,B,k,m+1,e);
		}
	}

}
