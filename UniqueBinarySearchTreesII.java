import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

public class UniqueBinarySearchTreesII {
	
	  public ArrayList<TreeNode> generateTrees(int n) {
		  return null;
	 }
	
//	public static void main(String[] args){
//		
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node4 = new TreeNode(4);
//		TreeNode node5 = new TreeNode(5);
//		
//		node1.left=node2;
//		node1.right=node3;
//		node3.left = node4;
////		node4.right = node5;
//		
//		System.out.println(OJSerializeBinaryTree(node1));
//		
//	}
//	
	
	
	public static String OJSerializeBinaryTree(TreeNode root){
		if (root == null) return "";
		
		StringBuilder sb = new StringBuilder();
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.offer(root);
		sb.append(root.val + ",");
		
		while(queue.size() > 0){
			TreeNode n = queue.remove();
			
			if(n.left != null){
				queue.offer(n.left);
				sb.append(n.left.val + ",");
			}
			else{
				sb.append("#" + ",");
			}
			if(n.right != null){
				queue.offer(n.right);
				sb.append(n.right.val + ",");
			}
			else{
				sb.append("#" + ",");
			}
		}
		
		String result = new String(sb);
		
		int i = result.length()-1;
		for(; i >=0 ; ){
			if(result.charAt(i) == ',' || result.charAt(i)=='#'){
				i--;
			}
			else{
				break;
			}
		}
		
		return result.substring(0, i+1);
	}

}
