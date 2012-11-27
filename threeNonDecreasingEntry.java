/*
 * http://csjobinterview.wordpress.com/2012/04/06/check-if-there-exist-3-non-decreasing-sequence-in-a-numeric-array/
 * Check if there exist 3 non-decreasing sequence in a numeric array
Posted on April 6, 2012 by Algorithms --- A Lot Of Fun
Problem:Given an unsorted numeric array, check if we can find 3 elements such that a[i] <= a[j] <= a[k] and i < j < k in 0(n) time.
 */
public class threeNonDecreasingEntry {
	
	public static void main(String[] args){
		int[] a= {4,7,5,1,3,8,9,6,2};
		System.out.print(Solution1(a));
	}
	
	public static boolean Solution1(int[] a){
		
		int[] minLeft = new int[a.length];
		int[] maxRight = new int[a.length];
		
		for(int i = 1; i < a.length; i++){
			minLeft[i] = a[i] < a[minLeft[i-1]] ? i : minLeft[i-1];
		}
		
		maxRight[a.length - 1] = a.length - 1; 
		for(int i = a.length - 2; i >= 0; i--){
			maxRight[i] = a[i] > a[maxRight[i+1]] ? i : maxRight[i+1];
		}
		
		for(int i = 0; i < a.length; i++){
			if(i > minLeft[i] && i < maxRight[i]){
				return true;
			}
		}
		return false;
	}
	
	public static boolean Solution2(int[] a){
		return false;
	}

}
