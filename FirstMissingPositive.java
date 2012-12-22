/*
 * First Missing Positive
Given an unsorted integer array, find the first missing positive integer.
For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.
Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] A){
		for(int i = 0; i < A.length; i++){
			while(A[i]!=i+1){
				if(A[i] <= 0 || A[i] > A.length){
					break;
				}
				else{
					int temp = A[i];
					A[i] = A[temp-1];
					A[temp-1] = temp;
				}
			}
		}
		
		for(int j = 0; j < A.length; j++){
			if(A[j] != j + 1){
				return j+1;
			}
		}
		return A.length + 1;
		
	}
	
	
	 public int firstMissingPositive2(int[] A) {
		 
		 for (int i = 0 ; i<A.length;i++){
			 if(A[i]<=0)
				 A[i] = A.length+1;
		 }
		 
		 for(int j = 0; j < A.length; j++){
			 int t = A[j] > 0 ? A[j] : -A[j];
			 if(t <= A.length){
				 if(A[t - 1] > 0){
					 A[t - 1] = -A[t - 1];
				 }
			 }
		 }
		 
		 for(int k = 0; k < A.length; k++){
			 if(A[k] > 0){
				 return k+1;
			 }
		 }
		 
		 return A.length+1;
	 }
	

}
