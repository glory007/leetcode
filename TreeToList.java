/*
 * this class convert a BST to a sorted doubly linked list (in place) 
 */
public class TreeToList {
	
	public static class Node{
		public Node left;
		public Node right;
		public int value;
		public Node(int v, Node l, Node r){
			this.left = l;
			this.right = r;
			this.value = v;
		}
	}
	
	public static class NodePair{
		public Node p1;
		public Node p2;
		public NodePair(Node p1, Node p2){
			this.p1 = p1;
			this.p2 = p2;
		}
	}
	
	public static NodePair run(Node treeRoot){
		NodePair leftPair;
		NodePair rightPair;
		
		Node head = treeRoot;
		Node tail = treeRoot;
		if(treeRoot.left != null){
			leftPair = TreeToList.run(treeRoot.left);
			treeRoot.left = leftPair.p2;
			leftPair.p2.right = treeRoot;
			head = leftPair.p1;
		}
		if(treeRoot.right != null){
			rightPair = TreeToList.run(treeRoot.right);
			treeRoot.right = rightPair.p1;
			rightPair.p1.left = treeRoot;
			tail = rightPair.p2;
		}
		return new NodePair(head, tail);
	}
	
	public static void main(String[] args){
		
		Node n1 = new Node(15, null, null);
		Node n2 = new Node(7, null, null);
		Node n3 = new Node(40, null, null);
		Node n4 = new Node(10, null, null);
		Node n5 = new Node(30, null, null);
		Node n6 = new Node(50, null, null);
		
		n1.left = n2;
		n1.right = n3;
		
		n2.right = n4;
		n3.left = n5;
		n3.right = n6;
		
		NodePair p = run(n1);
		
		Node h = p.p1;
		Node t = p.p2;
		
		while(h != null){
			System.out.println(h.value);
			h = h.right;
		}
		System.out.println("-----");
		while(t != null){
			System.out.println(t.value);
			t = t.left;
		}
		
	}

}
