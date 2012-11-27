// NOT CORRECT!!


/*
 * Given a binary tree, 
 * find the largest Binary Search Tree (BST), where largest means BST with largest number of nodes in it. 
 * The largest BST may or may not include all of its descendants.
 *              ___________________15___________________
              /                                        \
  ___________10___________                             20
 /                        \
 5                   _____12____
                    /          \
                  __2__       __5
                 /     \     /
                 0      8    3 
 */
public class LargestBinarySearchTree {
	private static class Pair{
		Integer v1;
		Integer v2;
		public Pair(Integer v1, Integer v2){
			this.v1 = v1;
			this.v2 = v2;
		}
	}
	
	
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(15);
		TreeNode n2 = new TreeNode(10);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(12);
		TreeNode n6 = new TreeNode(2);
		TreeNode n7 = new TreeNode(5);
		TreeNode n8 = new TreeNode(0);
		TreeNode n9 = new TreeNode(8);
		TreeNode n10 = new TreeNode(3);
		
		n1.left = n2;
		n1.right=n3;
		n2.left=n4;
		n2.right = n5;
		n5.left = n6;
		n5.right=n7;
		n6.left = n8;
		n6.right = n9;
		n7.left = n10;
		
		System.out.println (findLargest(n1));
		
		
	}

	public static int findLargest(TreeNode root){
		
		
		return findLargestHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE).v2;
	}
	
	public static Pair findLargestHelper(TreeNode root, int min, int max){
		if(root == null) return new Pair(0,0);
		
		Pair left = findLargestHelper(root.left, min, Math.min(max, root.val));
		Pair right = findLargestHelper(root.right, Math.max(min, root.val), max);
		
		int v1 = 1;
		int v2 = 0;
		
		if(root.left != null && root.val > root.left.val ){
			v1 += left.v1;
		}

		if(root.right != null && root.val < root.right.val){
			v1 += right.v1;
		}
		
		v2 = Math.max(v1, Math.max(left.v2, right.v2));
		
		return new Pair(v1,v2);
		
	}

}
