/*
 * Implement the following function, FindSortedArrayRotation, which takes as its input an array of unique integers 
 * that has been sorted in ascending order, then rotated by an unknown amount X where 0 <= X <= (arrayLength Ð 1). 
 * An array rotation by amount X moves every element array[i] to array[(i + X) % arrayLength].
 * FindSortedArrayRotation discovers and returns X by examining the array.
 */

/* 
 * if the array contains dups, then binary search will not work?
* why? thinking about case like "2222222222222222122" or "2122222222222222", 
* a binary search will not tell you which half to discard.
*/ 

public class FindSortedArrayRotation {
	
	public static void main(String[] arg){
		// case 1
		int[] a = {3,4,5,6,0,1};
		System.out.println(find(a));
		
		int[] b = {2,3,4};
		System.out.println(find(b));
		
		int[] c = {4,2,3};
		System.out.println(find(c));
		
		System.out.println("xx");
	}
	
    public  static int find(int[] a){

        int s = 0;
        int e = a.length - 1;
        while(s<e){
            int m = (s+e)/2;
            if(a[m] > a[e]){
                s = m+1;
            }
            else{
               e = m;
            }
        }
        return s;
    }
}