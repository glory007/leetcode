/*
 * problem: binary search with cost (each cost equals the value)
 * 
 */
public class BinarySearchWithCost {
	public static void main(String[] args){
		getWorstCaseCost(100);
	}
	
	// DP - O(N^3)
	public static void getWorstCaseCost(int x){
		int[][] r = new int[101][101];
		
		for(int i = 0; i<=99; i++){
			for(int j = 1; j+i <= 100; j++ ){
				int cur = Integer.MAX_VALUE;
				if(i==0){
					r[j][i+j] = 0;	
				}
				else{
					for(int k = j; k <= i+j; k++){
						int left = (k<=j+1) ? 0 : r[j][k-1];
						int right = (k >= i +j -1) ? 0 : r[k+1][i+j];
						int total = k + (right > left ? right : left);
						cur = total < cur ? total :cur;
					}
					r[j][i+j] = cur;
				}
			}
		}
		for (int i = 1; i <=100; i++){
			System.out.println(i + " " + "cost: " + r[1][i]);
		}
	}
}
