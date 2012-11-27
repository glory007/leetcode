// passed! both small and large cases.

// when dealing with an array of objects, be careful of the null in the objects.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class MergeKSortedLists {
	
	
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	
    	PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(100, new Comparator<ListNode>() {
            @Override public int compare(final ListNode o1, final ListNode o2) {
                if(o1.val < o2.val) return  -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
    	
    	int k = lists.size();
    	
    	ListNode dummyHead = new ListNode(-1);
    	ListNode cur = dummyHead;
    	
    	for(int i = 0; i < k; i++){
    		if (lists.get(i) != null)
    		    queue.add(lists.get(i));
    	}

    	while(!queue.isEmpty()){
    		ListNode n = queue.poll();
    		cur.next = n;
    		cur = n;
    		if(n.next!=null)
    		    queue.add(n.next);
    	}
    	
    	return dummyHead.next;
    }

}
