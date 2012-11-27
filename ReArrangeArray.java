/*
 * Given an array contains only 0s, 1s and 2s. Re-arrange the elements so that 1 follows 0 and 2 follows 1. 
 * E.g. 00011112222222. Do it in linear time.
 * 
 */
public class ReArrangeArray {
	
	public static void main(String[] args){
		int[] A=new int[]{1,2};
		int[] R = new ReArrangeArray() .reArrangeArray(A);
		
		for(int x : R){
			System.out.println(x);
		}
	}
	
	public int[] reArrangeArray(int[] A){ 
		if(A.length==0) return A;
		int pivot = 0;
		for (int i = 0; i <=2; i++){
			pivot = partition(A, pivot, A.length-1, i);
		}
		
		return A;
	}
	
	public int partition(int[] A, int start, int end, int value){

		while(start < end){
			if(A[start] <= value && A[end] > value){
				start++; end--;
			}
			else if (A[start] <= value && A[end] <= value){
				start++;
			}
			else if (A[start] > value && A[end] <= value){
				int temp = A[start];
				A[start] = A[end];
				A[end] = temp;
			}
			else{
				end--;
			}
		}
		
		return start;
	}
	
	

}
