/*
 * find connected components in the undirected graph.
 */

/*
 * given a matrix with 0 and 1, return the number of connected component（四向）
with edge 1
e.g
1 0 1
1 0 1
0 1 1. return 2
 */
public class ConnectedComponent {
	public static void main(String[] args){
		
		int[][] a =  {
				  {1, 0, 1, 1},
				  {1, 1, 0 ,0},
				  {1, 0, 1, 1},
				  {0, 0, 0, 1}
				};
		System.out.print(getNumberOfComponents(a));
	}

	// a is square matrix.
	public static int getNumberOfComponents(int[][] a){
		int result = 0;
		
		int[][] color = new int[a.length][a.length]; // 0: white, 1: gray, 2: black
		for (int i = 0; i < a.length; i++){
			for(int j = 0; j < a.length; j++){
				if(color[i][j] == 0 && a[i][j] == 1){
					result++;
					DFT(a, color, i, j);
				}
			}
		}
		return result;
	}
	
	private static void DFT(int[][] a, int[][] color, int i, int j) {
		color[i][j] = 1; // mark as gray first;
		
		if(i - 1 >= 0 && color[i-1][j] == 0 && a[i-1][j] == 1){
			DFT(a, color, i-1, j);
		}
		
		if(i + 1 < a.length && color[i+1][j] == 0 && a[i+1][j] == 1){
			DFT(a, color, i+1, j);
		}
		
		if(j + 1 < a.length && color[i][j+1] == 0 && a[i][j+1] == 1){
			DFT(a, color, i, j+1);
		}
		
		if(j - 1 >= 0 && color[i][j-1] == 0 && a[i][j-1] == 1){
			DFT(a, color, i, j-1);
		}
		color[i][j] = 2;
	}

}
