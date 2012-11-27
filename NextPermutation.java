/*
 * 
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

 */
public class NextPermutation {
	public static void main(String[] args){
		int[] num = {1,1,5};
		nextPermutation(num);
		for(int x : num){
			System.out.print(x + " ");
		}
	}
	
	
	/*
	 * The following algorithm generates the next permutation lexicographically after a given permutation. It changes the given permutation in-place.

Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
Find the largest index l such that a[k] < a[l]. Since k + 1 is such an index, l is well defined and satisfies k < l.
Swap a[k] with a[l].
Reverse the sequence from a[k + 1] up to and including the final element a[n].

After step 1, one knows that all of the elements strictly after position k form a weakly decreasing sequence, 
so no permutation of these elements will make it advance in lexicographic order; to advance one must increase a[k]. 
Step 2 finds the smallest value a[l] to replace a[k] by, and swapping them in step 3 leaves the sequence after position k in weakly decreasing order. 
Reversing this sequence in step 4 then produces its lexicographically minimal permutation, and the lexicographic successor of the initial state for 
the whole sequence.
	 */
	
	// do the permutation in place.
	public static void nextPermutation(int[] num){
		if(num.length==1) return;
		
		int i = num.length - 1;
		
		while(i-1>=0 && num[i-1] >= num[i]){
			i--;
		}
		int k = i-1;
		if(k<0){ // the permutation is the last permutation
			Reverse(num,0, num.length-1);
			return;
		}
		else{
			// find the largest index l such that a[k] < a[l]
			int l = num.length - 1;
			while(num[l] <= num[k]){
				l--;
			}
			// now swap a[k] with a[l]
			int tmp = num[l];
			num[l] = num[k];
			num[k] = tmp;
			Reverse(num, k+1, num.length-1);
		}
	}


	private static void Reverse(int[] num, int k, int i) {
		while(k<i){
			int tmp = num[k];
			num[k] = num[i];
			num[i] = tmp;
			k++;
			i--;
		}
	}
}
