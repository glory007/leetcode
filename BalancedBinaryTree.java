// SOLVED! both small and large cases (on a 2nd try..)

// be careful of the definition of balanced tree....

/*
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree
in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
	
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n4.left = n7;
		
		System.out.print(isBalanced(n1));
		
	}
	
	static class Tuple{
		boolean flag;
		int v1;
		public Tuple( boolean flag, int v1){
			this.flag = flag;
			this.v1 = v1;
		}
	}
    public static  boolean isBalanced(TreeNode root) {
    	Tuple t = isBalancedHelper(root);
    	return t.flag;
    }  
    
    public static Tuple isBalancedHelper(TreeNode root){
    	if(root == null) return new Tuple(true, 0);
    	Tuple t1 = isBalancedHelper(root.right);
    	Tuple t2 = isBalancedHelper(root.left);
    	
    	boolean flag = Math.abs(t1.v1 - t2.v1)<=1 && t1.flag && t2.flag;
    	int v1 = (t1.v1 > t2.v1 ? t1.v1 : t2.v1) + 1;
    	return new Tuple(flag,v1);
    }
}
