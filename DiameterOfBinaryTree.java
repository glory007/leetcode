// http://www.geeksforgeeks.org/archives/5687


public class DiameterOfBinaryTree {
	
	static class Node{
		Node left;
		Node right;
		int id;
		public Node(int id){
			this.id = id;
		}
	}
	
	static class Pair{
		final int v1;
		final int v2;
		public Pair(int v1, int v2){
			this.v1 = v1;
			this.v2 = v2;
		}
		
		public String toString(){
			return v1 + " " + v2 + "\n";
		}

	}
	
	public static void main(String[] args){
		
		Node r = new Node(1);
		System.out.print(getDiameter(r));
		
		Node r2= new Node(2);
		r.left = r2;
		System.out.print(getDiameter(r));
		
		Node r3= new Node(3);
		r.right = r3;
		System.out.print(getDiameter(r));
		
		Node r4= new Node(4);
		Node r5= new Node(5);
		r3.left= r4; r3.right = r5;
		System.out.print(getDiameter(r));
		
		Node r6= new Node(6);
		Node r7= new Node(7);
		Node r8= new Node(8);
		Node r9= new Node(9);
		r4.left = r6;
		r6.left = r8;
		r7.left = r9;
		r5.right = r7;
		
		System.out.print(getDiameter(r));
	}
	
	public static Pair getDiameter(Node n){
		int l1 = 0, l2 = 0;
		if(n.left != null){
			Pair p1 = getDiameter(n.left);
			l1 = p1.v1;
			l2 = p1.v2;
		}
		
		int r1 = 0, r2 = 0;
		if(n.right != null){
			Pair p2 = getDiameter(n.right);
			r1 = p2.v1;
			r2 = p2.v2;
		}
		
		int t1, t2 = 0;
		t1 = (l1 > r1) ? (l1 +1) : (r1 + 1);
		
		int tmp = (l2 > r2) ? l2 : r2;
		
		t2 = tmp > (l1+r1+1) ? tmp : (l1+r1+1);
		
		return new Pair(t1, t2);
	}


}
