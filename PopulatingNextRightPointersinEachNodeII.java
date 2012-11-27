// SOLVED! both small and large cases. However, the requirement of "only use constant extra space" is not met!!

import java.util.LinkedList;
import java.util.Queue;

/*
 * You may only use constant extra space.
 */
/*
 * Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
    
 */



public class PopulatingNextRightPointersinEachNodeII {
	
	public static void main(String[] args){
		TreeLinkNode node1 = new  TreeLinkNode(1);
		TreeLinkNode node2 = new  TreeLinkNode(2);
		TreeLinkNode node3 = new  TreeLinkNode(3);
		TreeLinkNode node4 = new  TreeLinkNode(4);
		TreeLinkNode node5 = new  TreeLinkNode(5);
		TreeLinkNode node6 = new  TreeLinkNode(6);
		TreeLinkNode node7 = new  TreeLinkNode(7);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.right = node7;
		
		connect(node1);
	}
	 

	// a smarter way (just use O(1) storage)
	// passed! both small and large cases!
	public static void connect2(TreeLinkNode root) {
		if (root == null) return;
		TreeLinkNode curr_head = root;

		while(curr_head != null){
			TreeLinkNode next_level_pivot = new TreeLinkNode(-1);
			TreeLinkNode next_head = null;
			while(curr_head != null){
				if(curr_head.left != null){
					next_level_pivot.next = curr_head.left;
					next_level_pivot = curr_head.left;
					next_head = (next_head == null) ? next_level_pivot : next_head;
				}
				if(curr_head.right != null){
					next_level_pivot.next = curr_head.right;
					next_level_pivot = curr_head.right;
					next_head = (next_head == null) ? next_level_pivot : next_head;
				}
				curr_head = curr_head.next;
			}
			curr_head = next_head;
		}
	}
	
	static class QueueNode{
		TreeLinkNode node;
		int level;
		public QueueNode(TreeLinkNode n, int level){
			this.node = n;
			this.level = level;
		}
	}

	public static void connect(TreeLinkNode root) {
		if (root== null) return;
		
		Queue<QueueNode> queue = new LinkedList<QueueNode>();
		
		queue.add(new QueueNode(root, 1));
		
		while(!queue.isEmpty()){
			QueueNode n = queue.poll();
			
			if(!queue.isEmpty() && queue.peek().level == n.level){
				n.node.next = queue.peek().node;
			}
			if(n.node.left!=null)
				queue.add(new QueueNode(n.node.left, n.level+1));
			if(n.node.right!=null)
				queue.add(new QueueNode(n.node.right, n.level+1));
		}
    }

}
