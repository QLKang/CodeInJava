package leetcode.linkedlist.reorderlist;
/*Update: Mar.3, 2015, methodII is better than methodI. II: time: O(n), in place. I:time: O(n^2), in place */
public class ReorderList {
	/*Update: Mar.3, 2015, time: O(n^2), in place */
//	final static ListNode FH = new ListNode(0);
	public static void reorderList(ListNode head) {
		if(head==null || head.next==null || head.next.next==null)
			return;
		
		ListNode rHead = head, rNext = null, rPreTail = null, rTail = null;
		
		// If rHead.next ==null, the there are odd nodes in list. If rHead.next.next==null, there are even nodes in list
		// When rHead.next==null, we have one node left to operate. Since one node does not need to be reordered, the loop is terminated.
		// When rHead.next.next==null, we have two nodes left to operate. Since two nodes do not need to be reordered, the loop is terminated.
		while(rHead.next!=null && rHead.next.next!=null){
			
			rTail = rHead;
			// rHead.next!=null, thus, rTail could not be null and rTail.next is reasonable
			// if rTail.next==null, then we find the tail of the list
			while(rTail.next!=null){
				rPreTail = rTail;
				rTail = rTail.next;
			}
			
			rNext = rHead.next; // we mark rHead.next as rNext which will be the new head of list being reversed
			rHead.next = rTail;
			rTail.next = rNext;
			rPreTail.next = null; // we setup a new tail of list.
			
			rHead = rNext; // update rHead do not forget it
		} // end while
		
	} // end method

	
	// method II, inplace, time: O(n)
	public static void reorderListII(ListNode head){
		
		// if there are no nodes, one nodes or two nodes in the list, we do not change the list and return
		if(head==null || head.next ==null || head.next.next==null)
			return;
		
		ListNode h1 = null, h2 = null, slow = null, fast = null, pre=null;
		h1=head;
		slow=head;
		fast = head;
		
		// we use slow and fast points to separate the list into two even parts(both have n/2 nodes if even, or n/2 and n/2+1 if odd)
		// h1 is the head of first part, h2 is the head of second part
		while(fast!=null && fast.next!=null){
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		pre.next= null;
		h2 = slow;
		
		ListNode head2 = reverse(h2);
		merge(h1, head2);
		
		return ;
	}
	
	
	private static ListNode reverse(ListNode h2){
		if(h2 == null || h2.next == null)
			return h2;
		ListNode FH = new ListNode(0);
		ListNode pre = null, curr = null, next = null, temp = null;
		FH.next = h2;
		pre=FH;
		curr = h2;
		next = curr.next; // since curr.next!=null, next could not be null
		// since h2.next!=null, the initial curr.next could not be null. it is reasonable.
		while(next!=null){
			temp = next.next; // temp might be null or not null
			next.next = curr;
			curr.next = pre;
			// update
			pre = curr;
			curr = next;
			next = temp;
		}
		
		h2.next = null; // h2.next is fakehead, thus we need set it to null at last.
		
		return curr; // curr is the new head of reversed list
	}
	
	private static void merge(ListNode head1, ListNode head2){
		if(head1==null ||head2==null)
			return;
		
		// length1 of list1 == length2 of list2, or length1 + 1 = length2
		while(head1.next!=null){
			ListNode next = head1.next;
			head1.next = head2;
			head1 = head2;
			head2 = next;
		}
		head1.next = head2;
		
		return ;
	}
	
} // end class 
