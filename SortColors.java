// SOLVED. both small and large cases
/*
 * Sort Colors
Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
	
	public static void main(String[] args){
		int[] A = new int[]{2,1,0,0,2};
		new SortColors().sortColors(A);
		for (int x : A){
			System.out.println(x);
		}
	}
	
    public void sortColors(int[] A) {
    	if(A.length <= 1) return;
    	
    	int s = 0;
    	int e = A.length - 1;
    	int t = 0;
    	
    	// *IMPORTANT* be careful of exit condition for while loop.
    	while(s <= e){
    		if(A[s] == 2) swap(A, s, e--);
    		else if(A[s] == 0){
    			swap(A, s++, t++);
    		}
    		else if(A[s] == 1){
    			s++;
    		}
    	}
    }
    
    public static void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}