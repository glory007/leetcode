
public class MaximumSumPathinBinaryTree {
	
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(-2);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(8);
		TreeNode n5 = new TreeNode(-4);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		
		System.out.println(getPathSum(n1));
		
	}
	
	public static int getPathSum(TreeNode root){
		
		
		return getPathSumHelper(root, 0);
	}

	
	public static int getPathSumHelper(TreeNode root, int sum){
		
		if(root == null) return sum;
		
		return Math.max( getPathSumHelper(root.left, sum + root.val), getPathSumHelper(root.right, sum + root.val));
		
	}
}
