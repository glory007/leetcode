import java.util.ArrayList;
/*
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

public class UniqueBinarySearchTreesII {
	 public ArrayList<TreeNode> generateTrees(int n) {
		 ArrayList[][] map = new ArrayList[n+1][n+1];
		 return generateTree(1, n, map);
	 }
	 
	 @SuppressWarnings("unchecked")
	 public ArrayList<TreeNode> generateTree(int start, int end, ArrayList[][] map){
		 ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		 
		 if(start > end) {
			 list.add(null);
			 return list;
		 }
		 
		 if(map[start][end]!= null){
			 return map[start][end];
		 }

		 for(int i = start; i <= end; i++){
			 ArrayList<TreeNode> left = generateTree(start, i-1, map);
			 ArrayList<TreeNode> right = generateTree(i+1, end, map);
			 for(TreeNode r : right){
				 for(TreeNode l : left){
					 TreeNode root = new TreeNode(i);
					 root.right = r;
					 root.left = l;
					 list.add(root);
				 }
			 }
		 }
		 map[start][end]=list;
		 return list;
	 }
}
