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