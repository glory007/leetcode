/*
 * 
 * two nice ways to do majority vote:
 * 1. moore algo
 * 2. from stack overflow
 * http://stackoverflow.com/questions/278488/puzzle-find-the-most-common-entry-in-an-array
 */


public class MajorityVoteAlgorithm {
	
	public static void main(String[] args){
		int[] A = new int[] {1,2,3,3454,3454,3454,3,3454,5,3454,3454};
		System.out.print(getMajority(A));
	}
	
	// this function need the assumption that array A must contains a majority element (times of occurence > Array Length/2)
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
