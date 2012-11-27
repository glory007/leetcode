
// solved!
// but any better ways?

public class SearchinRotatedSortedArrayII {
	
	 public boolean search(int[] A, int target) {
		  if(A == null || A.length==0) return false;
		  return search(A, target, 0 , A.length -1);
		  
	 }

     public boolean search(int[] A, int target, int s, int e) {
	     if(target == A[s] || target == A[e]){
	          return true;
	     }
	     
	     while(s<e-1){
	         int m = (s+e) / 2;
	         if(target == A[m]) return true;
	         
	         if(A[m] == A[s]){
	        	 return search(A, target, s, m) ||  search(A, target, m, e);
	         }
	        
	         if(target > A[m] && A[m] > A[s]){
	             s = m;
	         }
	         else if (target > A[m] && A[m] < A[s]){
	             if(target > A[s]){
	                 e = m;
	             }
	             else{
	                 s = m;
	             }
	             
	         }
	         else if (target < A[m] && A[m] > A[s]){
	             if(target > A[s]){
	                 e = m;
	             }
	             else{
	                 s = m;
	             }
	         }
	         else{
	             e = m;
	         }
	     } 
         return false;
     }
}
