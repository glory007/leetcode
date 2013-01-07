// solved! both small and large cases

/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

 */
public class RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
    	// 0 node or 1 node list.
    	if(head == null || head.next == null) return head;
    	
    	ListNode node = new ListNode(-1);
    	ListNode node_copy = node;
    	
    	ListNode prev = null;
    	
    	while(head != null){
    		boolean f1 = false;
    		boolean f2 = false;
    		
    		if(prev!=null && head.val == prev.val)
    			f1= true;
    		if(head.next!=null && head.val == head.next.val )
    			f2 = true;
    		
    		if(!f1 && !f2){
    			node.next = head;
    			node = node.next;
    		}
    		
			prev = head;
    		head = head.next;
    	}
    	
    	node.next = null;
    	
    	return node_copy.next;
    }
}
