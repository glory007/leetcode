// solved both small and large cases.

/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {
	
    public ListNode deleteDuplicates(ListNode head) {
    	if(head== null) return null;
    	
    	ListNode head_copy = head;
    	ListNode cur_node = head;
    	
    	head = head.next;
    	while(head!=null){
    		if(head.val != cur_node.val){
    			cur_node.next = head;
    			cur_node = head;
    		}
    		head=head.next;
    	}
    	cur_node.next = null; // be careful of setting this last pointer in the linked list.
    	return head_copy;
    }
        
}
