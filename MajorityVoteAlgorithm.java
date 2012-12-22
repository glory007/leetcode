/*
 * 
 * two nice ways to do majority vote (without using O(n) extra space, otherwise it will be easy..):
 * 1. moore algo
 * 2. from stack overflow
 * http://stackoverflow.com/questions/278488/puzzle-find-the-most-common-entry-in-an-array
 */


public class MajorityVoteAlgorithm {
	
	public static void main(String[] args){
		int[] A = new int[] {1,2,3,3454,3454,3454,3,3454,5,3454,3454};
		System.out.println(getMajority(A));
		
		int[] A2 = new int[] {1,2,3,2,3};
		System.out.println(getMajority(A2));
	}
	
	
	// this algorithm also need the assumption that array A must contains a majority element (times of occurence > Array Length/2)
	//	http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
	public static int MooreMajorityVoteAlgo(int[] A){
	
		int count = 0;
		int candidate = Integer.MIN_VALUE; // assume input array A does not have Integer.MIN_VALUE
		
		for(int i = 0; i < A.length; i++){
			if(count == 0){
				count++;
				candidate = A[i];
			}
			else{
				count = A[i] == candidate ? count+1 : count-1;
			}
		}
		return candidate;
	}
	
	// this function need the assumption that array A must contains a majority element (times of occurence > Array Length/2)
    // also assuming input integer is 32 bit integer.	
	public static int getMajority(int[] A){
		int[] bitsCount = new int[32];
		
		for(int a : A){
			for(int i = 0; i < 32; i++){
				int t = a & (1 << i);
				if(t != 0){
					bitsCount[i]++;
				}
			}
		}
		
		int n = 0;
		for(int i = 0; i < 32; i++){
			if(bitsCount[i] > A.length /2)
			    n = n | (1<<i);
		}
		
		return n;
	}

}
