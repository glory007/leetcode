// solved! both small and large cases.

/*
 * Convert Sorted Array to Binary Search Tree
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArraytoBST {
	
    public TreeNode sortedArrayToBST(int[] num) {
    	return sortedArrayToBSTHelper(num,0,num.length-1);
    	
    	
    }
    
    public static TreeNode sortedArrayToBSTHelper(int[] num, int s, int e){
    	if(s > e) return null;
    	int m = (s+e)/2;
    	
    	TreeNode root = new TreeNode(num[m]);
    	root.left = sortedArrayToBSTHelper(num,s,m-1);
    	root.right = sortedArrayToBSTHelper(num,m+1,e);
    	return root;
    	
    }

}
