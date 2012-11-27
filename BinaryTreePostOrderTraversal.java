import java.util.Stack;

/*
 * Do a postorder binary tree traversal with constant memory (no stacks).   View Answers (2)
 *
 * Post Order Traversal: left-> right-> root
 */
public class BinaryTreePostOrderTraversal {
	
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		node1.left=node2;
		node1.right=node3;
		node2.right=node4;
		node4.right=node8;
		node3.left=node5;
		node3.right=node6;
		node6.right=node7;
		
		postOrderTraversal(node1);
	}
	
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	     boolean leftVisited = false;
	     boolean rightVisited = false;
	 }
	 
	
	public static void postOrderTraversal(TreeNode root){
		if (root == null) return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		s.push(root);
		
		while(!s.isEmpty()){
			if(s.peek().leftVisited == false && s.peek().left != null){
				s.peek().leftVisited = true;
				s.push(s.peek().left);
			}
			else if (s.peek().rightVisited == false && s.peek().right != null){
				s.peek().rightVisited = true;
				s.push(s.peek().right);
			}
			else{
				System.out.println (s.pop().val);
			}
		}
		
	}

}
