// SOLVED ! both small and large cases. any better ways? (in terms of space or run time effiency?)

import java.util.ArrayList;
import java.util.List;

/*
 * Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.
Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class RecoverBinarySearchTree {
	
	/*
	 * better ways. both small cases and large cases passed. run time: O(n), space: O(logn) since recursion is used to do in order traversal.
	 */
	public void recoverTree2(TreeNode root){
		List<TreeNode> swaps = new ArrayList<TreeNode>();
		TraverseAndFindSwappedNode(root, null, swaps);
		
		 // now swap the value
		int tmp = swaps.get(0).val;
		swaps.get(0).val = swaps.get(1).val;
		swaps.get(1).val = tmp;
		
		 return;
	}
	
	public TreeNode TraverseAndFindSwappedNode(TreeNode root, TreeNode prev, List<TreeNode> swaps){
		if(root == null) return null;
		TreeNode prev2 = TraverseAndFindSwappedNode(root.left, prev, swaps);
		prev = prev2 != null ?  prev2 : prev;
		
		// handle the root node.
		if(swaps.size()==0 && prev != null && root.val < prev.val){
			swaps.add(prev);
			swaps.add(root);
		}
		else if(swaps.size()==2){
			if(swaps.get(1).val > root.val){
				swaps.remove(1);
				swaps.add(root);
			}
		}

		if(root.right== null){
			return root;
		}
		else{
		    return TraverseAndFindSwappedNode(root.right, root, swaps);
		}
		
	}
	
	/*
	 * running time O(n), where n is the number of nodes in the tree. space:o(n)
	 */
	 public void recoverTree(TreeNode root) {
	 
		 if (root == null) return ;
		 
		 final ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		 Traverse(root, list);
		 
		 // now find the swapped element in the list.
		 int[] swapped_indexes = new int[2];
		 int i = 0;
		 while( list.get(i).val < list.get(i+1).val){
			 i++;
		 }
		 swapped_indexes[0] = i; // found the swap index 1.
		 
		 int j = i + 1;
		 swapped_indexes[1] = j;
		 int value = list.get(j).val;
		 while(j < list.size()){
			 if(list.get(j).val < value){
				 value = list.get(j).val;
				 swapped_indexes[1] = j;
			 }
			 j++;
		 }
		 
		 // now swap the value
		 int tmp = list.get(swapped_indexes[0]).val;
		 list.get(swapped_indexes[0]).val = list.get(swapped_indexes[1]).val;
		 list.get(swapped_indexes[1]).val = tmp;
		 return;
		 
		 
		 /* another way to find the swapped index is to actually sort the array - not optimal in term of running time efficiency.
		 final Integer[] index = new Integer[list.size()];
		 for(Integer i = 0 ; i < list.size(); i++){
			 index[i] = i;
		 }
		 
		 Arrays.sort(index,  new Comparator< Integer >() {
	            @Override public int compare(final Integer o1, final Integer o2) {
	                if(list.get(o1).val < list.get(o2).val) return  -1;
	                else if (list.get(o1).val == list.get(o2).val) return 0;
	                else return 1;
	            }
	        });
		 
		 for(int i = 0 ; i < index.length; i++){
			 if(index[i] != i){
				 int tmp = list.get(i).val;
				 list.get(i).val = list.get(index[i]).val;
				 list.get(index[i]).val = tmp;
				 return;
			 }
		 }
		 */
	 }
	 
	 /*
	  * in order traversal
	  */
	 public static void Traverse(TreeNode root, List<TreeNode> list){
		 if(root == null) return;
		 Traverse(root.left, list);
		 list.add(root);
		 Traverse(root.right, list);
	 }
}
