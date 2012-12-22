// SOLVED! both small and large cases!

import java.util.ArrayList;
import java.util.Stack;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeInorderTraversal {
	
	  /* Constructed binary tree is
    1
  /   \
2      3
/  \
4     5
*/
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		
		inorderMorrisTraversal(n1);
	}
	
	/*
	 * in order tree traversal without using recursion and without using stack.
	 * http://www.geeksforgeeks.org/archives/6358 
	 */
	public  static void inorderMorrisTraversal(TreeNode root) {
		TreeNode cur = root;
		
		while(cur != null){
			if(cur.left == null){
				System.out.println(cur.val);
				cur = cur.right;
			}
			else{
				TreeNode n = cur.left;
				
				while(n.right != null && n.right != cur){
					n= n.right;
				}
				
				if(n.right == null){
					n.right = cur;
					cur = cur.left;
				}
				else{
					n.right = null;
					System.out.println(cur.val);
				    cur = cur.right;	
				}
			}
		}
	}   
	
	/*
	 * in order tree traversal without using recursion
	 */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	if (root == null) return new ArrayList<Integer>();

    	ArrayList<Integer> r = new ArrayList<Integer>();
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	TreeNode cur = root;
    	
    	push(cur, s);
    	
    	while(!s.isEmpty()){
    		TreeNode tmp = s.pop();
    		r.add(tmp.val);
    		push(tmp.right,s);
    	}
    	return r;
    }
    
    public static void push(TreeNode node, Stack<TreeNode> s){
    	if (node== null) return;
    	
    	TreeNode cur = node;
    	
    	while(cur!=null){
    		s.push(cur);
    		cur = cur.left;
    	}
    }
}