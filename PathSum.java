// solved! both small and large cases
public class PathSum {

	
    public static boolean hasPathSum(TreeNode root, int sum) {

    	if(root == null) return false;
    	
    	if(root.left == null && root.right == null)
    		return sum == root.val;
    	else if (root.left != null && root.right != null){
    		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    	}
    	else if (root.left!=null){
    		return hasPathSum(root.left, sum - root.val) ;
    	}
    	else{
    		return hasPathSum(root.right, sum - root.val);
    	}
    }
}
