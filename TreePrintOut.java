import java.util.Stack;


/*
 * give a binary tree, print out as this:
 *          1
 *        2   3
 *      4  5 6 7
 * 
 * Expected print out: 1 -> 2 -> 3 -> 7 -> 6 -> 5 -> 4
 */

public class TreePrintOut {
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
	
	public static void print(Node root){
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(root);
		
		print(s1, s2, true);
	}
	
	public static void print(Stack<Node> s1, Stack<Node> s2, boolean rightFirst){
		
		while(!s1.isEmpty()){
			Node t = s1.pop();
			System.out.println(t.value);
			if(rightFirst){
				push(s2, t.right);
				push(s2, t.left);
			}
			else{
				push(s2, t.left);
				push(s2, t.right);
			}
		}
		
		if(!s2.isEmpty())
    		print(s2, s1, !rightFirst);
	}
	
	public static void push(Stack<Node> s, Node t){
		if (t!=null){
			s.push(t);
		}
	}
	
	public static void main(String[] arg){
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
		
		print(n1);
	}

}
