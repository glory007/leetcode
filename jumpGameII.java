/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
For example:
Given array A = [2,3,1,1,4]
The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */


public class jumpGameII {
	
	public static void main(String[] args){
		int[] A={2,3,1,1,4};
		System.out.print(new jumpGameII().jump(A));
	}
	
	 public int jump(int[] A) {
		 
		 int start=0, end=0, count=0, next=end;
	     
		 if(A.length <=1)
	         return 0;

	     while(true)
	     {
             count++;
             for(int i=start; i<=end && i < A.length; i++)
             {
                 if(A[i]+i > next)
                     next = A[i]+i;
             }

             if(next >= A.length -1)
                 return count;
             if(next == end)
                 return -1;
  
             start = end + 1;
             end = next;
	        }
	 }
}
