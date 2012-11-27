class Solution {
  public int equi ( int[] A ) {
	  if(A.length<=1) return 0;
	  int sum = 0;
	  for(int x : A){
		  sum+=x;
	  }
	  
	  int right_sum = 0;
	  int left_sum = sum;
	  
	  for(int i = 0 ; i < A.length; i++){
		
		  left_sum -= A[i];
		  
		  if(i-1>=0){
			  right_sum += A[i-1];
		  }
		  
		  if (left_sum == right_sum){
			  return i;
		  }
	  }
	  
	  return -1;
	  
	  
  }
}
