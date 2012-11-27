//Reverse a linked list from position m to n. Do it in-place and in one-pass.

//1->2->3->4->5

//m=2 n=4

//1->4->3->2->5

public class ReverseLinkedListII {
	
	
	public static void main(String[] agrs){
		
		ListNode node1 = new ListNode(1);

		ListNode node2 = new ListNode(2);

		ListNode node3 = new ListNode(3);

		ListNode node4 = new ListNode(4);

		ListNode node5 = new ListNode(5);
		

		node1.next = node2;

		node2.next = node3;

		node3.next = node4;	

		node4.next = node5;
		
		ListNode root = reverseBetween(node1,5,5);
		
		while(root!=null){
			System.out.println(root.val);
			root = root.next;
		}
	
	}
	
	public static  ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null) return null;
		
		ListNode pivot = new ListNode(-1);
		pivot.next = head;
		
		ListNode before_m = pivot;
		
		int tmp = m-1;
		while(tmp > 0){
			before_m = before_m.next;
			tmp--;
		}
		
		ListNode start_node = before_m.next;
		//now reverse node from m to n.
		ListNode next_node = start_node.next;
		while(n > m){
			ListNode tmp_node = next_node.next;
			next_node.next = start_node;
			start_node = next_node;
			next_node = tmp_node;
			n--;
		}
		
		if(before_m.next != null){
			before_m.next.next = next_node;
		}
		
		before_m.next = start_node;
		return pivot.next;
    }

}
