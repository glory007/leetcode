// SOLVED! small case solved. big case also accepted!

import java.util.Arrays;

// Trapping Rain Water
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
// 
// For example, 
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

public class TrappingRainWater {
	public static void main(String[] args){
		int[] A= { 0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap2(A));
	}
	
	/*
	 * both small and large case passed.
	 * worst case: 
	 * O(N)
	 */
	public static int trap2(int[] A){
		if (A.length<=2) return 0;
        
		int[] L = new int[A.length];
		L[0] = A[0];
		for(int i = 1; i < A.length; i++){
			L[i] = L[i-1] > A[i] ? L[i-1] : A[i];
		}
		
		int[] R = new int[A.length];
		R[A.length-1] = A[A.length-1];
		for(int i = A.length-2; i>=0; i--){
			R[i] = R[i+1] > A[i] ? R[i+1] : A[i];
		}

		int r = 0;
		for(int i = 0; i< A.length; i++){
			int m = L[i] < R[i] ? L[i] : R[i];
			r += (m-A[i]);
		}
		
		return r;
	}
	
	/*
	 * both small and large case passed.
	 * worst case: 
	 * O(N^2)
	 */
	public int trap(int[] A) {
        if (A.length<=2) return 0;
        
        int[] B = new int[A.length];
        for(int i = 0; i < A.length; i++){
           B[i] = A[i];
        }
        
        Arrays.sort(B);
        
        int prev_floor = B[0];
        int count = 0;
        
        for(int i = 1; i < B.length; i++){
            int curr = B[i];
            if(curr == prev_floor){
                continue;
            }
            int step = curr - prev_floor;
            
            int prev_index = -1;
            for(int j = 0; j < A.length; j++){
                if(A[j] >= curr){
                	if(prev_index!=-1){
                		count+= step* ( j - prev_index-1);
                	}
                    prev_index = j;
                }
            }
            prev_floor = curr;
        }
        return count;
    }
}