// solved! both small and large cases

/*
 * Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
*/

public class SameTree {
	
	public static boolean isSameTree(TreeNode root1, TreeNode root2) {
    	 if(root1 == null && root2 == null)
			 return true;
	 
		 if(root1 == null || root2 == null)
			 return false;
		 
		 return (root1.val== root2.val) && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
	 }

}
