// SOLVED! both small and large cases

// Rotate Image
// You are given an n x n 2D matrix representing an image.
// 
// Rotate the image by 90 degrees (clockwise).
// 
// Follow up:
// Could you do this in-place?

public class RotateImage {
	
	
	public static void main(String[] arg){
		int[][] im = new int[][]{
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		new RotateImage().rotate(im);
		
		System.out.print("a");
	}
    public void rotate(int[][] matrix) {
    
        flip(matrix);
        swap(matrix);
    }
    
    public void flip(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    
    public void swap(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            int s = 0; int e = n-1;
            while(s<e){
                int  t = matrix[i][s];
                matrix[i][s] = matrix[i][e];
                matrix[i][e] = t;
                s++;e--;
            }
        }
    
    }
}