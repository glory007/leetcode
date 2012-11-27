// SOLVED. both small and large cases

public class SortColors {
	
	public static void main(String[] args){
		int[] A = new int[]{2,1,0,0,2};
		new SortColors().sortColors(A);
		for (int x : A){
			System.out.println(x);
		}
		
	}
	
    public void sortColors(int[] A) {
        if (A==null || A.length<=1) return;
        
        int p1 = -1;
        int q = A.length-1;
        
        for(int i = 0; i <= q;){
            if(A[i] == 0){
                swap(A, i++, ++p1);
            }
            else if (A[i]==2){
                swap(A, i, q--);
            }
            else{
                i++;
            }
        }
                
    }
    
    public static void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}