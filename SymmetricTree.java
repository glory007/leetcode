import java.util.Stack;

// SOLVED! both small and large cases

// how to do this iteratively?

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {
    
	// recursive version
	public boolean isSymmetric(TreeNode root) {
    	if(root == null) return true;
    	
    	return isMirrored2(root.left, root.right);
    }
    
    public static boolean isMirrored(TreeNode t1, TreeNode t2){
    	if(t1== null && t2 == null) return true;
    	
    	if(t1== null || t2 == null) return false;
    	
    	return (t1.val == t2.val &&
    			isMirrored(t1.right, t2.left) &&
    			isMirrored(t2.right, t1.left) );
    }
    
    
    // iterative version
    public static boolean isMirrored2(TreeNode t1, TreeNode t2){
    	if(t1== null && t2 == null) return true;
    	
    	if(t1== null || t2 == null) return false;
    	
    	Stack<TreeNode> s1 = new Stack<TreeNode>();
    	Stack<TreeNode> s2 = new Stack<TreeNode>();
    	
    	s1.push(t1);
    	s2.push(t2);
    	
    	while(!s1.isEmpty() && !s2.isEmpty()){
    		TreeNode tmp1 = s1.pop();
    		TreeNode tmp2 = s2.pop();
    		
    		if(tmp1.val != tmp2.val) 
    			return false;
    		
    		if(tmp1.right == null && tmp2.left != null){
   				return false;
    		}
    		if(tmp1.left == null && tmp2.right != null){
   				return false;
    		}

    		// TODO: refactor this, make a function to reduce code redundancy.
    		if(tmp1.right != null){
    			s1.push(tmp1.right);
    		}
    		if(tmp1.left != null){
    			s1.push(tmp1.left);
    		}
    		
    		if(tmp2.left != null){
    			s2.push(tmp2.left);
    		}
    		if(tmp2.right != null){
    			s2.push(tmp2.right);
    		}
    	}
    	
    	if(s1.isEmpty() && s2.isEmpty()){
    		return true;
    	}
    	
    	return false;
    }
    
    
    
    
}

