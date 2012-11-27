import java.util.PriorityQueue;

//given an array of n unsorted integers and each number is at most k positions away from its final sorted position, give an efficient sorting algorithm.

public class SortArrayKPositionsAway {
	
	
	public static void main(String[] args){
		int[] a = {1,3,5,4,2};
		
		int[] b = sort(a,3);
		
		for(int x : b){
			System.out.println(x);
		}
	}
	
	public static int[] sort(int[] a, int k){
		int[] b = new int[a.length];
		PriorityQueue<Integer> p = new PriorityQueue<Integer>(); 
		
		for(int i = 0; i < k+1 ; i++){
			p.add(a[i]);
		}
		
		for(int j = 0, i = k+1; j < b.length; j++, i++){
			b[j] = p.remove();
			if(i < a.length){
				p.add(a[i]);
			}
		}
		return b;
	}

}
