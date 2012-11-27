// NOT SOLVED!! Small case accepted, but big case failed (runtime error).


/*
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
public class BinaryTreeMaximumPathSum {
	
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		n1.left = n2;
		
		System.out.println(maxPathSum(n1));
	}
	
	
	private static class Pair{
		Integer v1;
		Integer v2;
		public Pair(Integer v1, Integer v2){
			this.v1 = v1;
			this.v2 = v2;
		}
	}
	
    public static  int maxPathSum(TreeNode root) {
    	Pair p = maxPathSumHelper(root);
    	return p.v2;
    }
    
    public static Pair maxPathSumHelper(TreeNode root){
    	if(root == null) return new Pair(0,0);
    	
    	Pair left = maxPathSumHelper(root.left);
    	Pair right = maxPathSumHelper(root.right);
    	
    	int v1 = 0;
    	if(left.v1 <= 0 && right.v1 <= 0 ){
    		v1 = root.val;
    	}
    	else{
    		v1 = left.v1 > right.v1 ? left.v1 + root.val : right.v1 + root.val;
    	}
    	
    	int v2 = ((left.v1 > 0) ? left.v1 : 0 ) + ( (right.v1 > 0) ? right.v1 : 0 ) + root.val;
        if (root.right != null){
    		v2 = ( v2 > right.v2 ) ? v2 : right.v2;
    	}
        
    	if (root.left != null){
    		v2 = ( v2 > left.v2 ) ? v2 : left.v2;
    	}
    	
    	return new Pair(v1,v2);
    }

}
