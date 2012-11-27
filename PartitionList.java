// SOLVED! both small and large cases

/*
 * Partition List
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class PartitionList {
	
	public ListNode partition(ListNode head, int x) {
	
		// just one node case.
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode head1 = new ListNode(Integer.MAX_VALUE);
		ListNode head2 = new ListNode(Integer.MAX_VALUE);

		ListNode cur1 = head1;
		ListNode cur2 = head2;
		
		while(head!=null){
			ListNode tmp = head.next;
			if(head.val < x){
				cur1.next = head;
				cur1 = head;
			}
			else{
				cur2.next = head;
				cur2 =head;
			}
			head.next = null;
			head = tmp;
		}
		
		// append head2 to head1;
		cur1.next = head2.next;
		
		return head1.next;
	}

}
