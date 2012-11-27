import java.util.Stack;


// root -> left -> right

public class BinaryTreePreOrderTraversal {
	
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
		
		preOrder(node1);
	}
	

	public static void preOrder(TreeNode root){
		if (root == null) return;
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		s.push(root);
		
		while(!s.isEmpty()){
			TreeNode n = s.pop();
			System.out.println(n.val);
			
			if(n.right != null) 
				s.push(n.right);
			
			if(n.left != null)
				s.push(n.left);
		}
		
		
	}
}
