// SOLVED ! both small and large cases. any better ways? (in terms of space or run time effiency?)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * 
 */
public class RecoverBinarySearchTree {

	 public void recoverTree(TreeNode root) {
	 
		 if (root == null) return ;
		 
		 final ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		 Traverse(root, list);
		 
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
	 }
	 
	 public static void Traverse(TreeNode root, List<TreeNode> list){
		 if(root == null) return;
		 
		 Traverse(root.left, list);
		 list.add(root);
		 Traverse(root.right, list);
		 
	 }
}
