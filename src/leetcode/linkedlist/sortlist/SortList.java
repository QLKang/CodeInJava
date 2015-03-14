package leetcode.linkedlist.sortlist;

public class SortList {
	
	public static ListNode sortList(ListNode head){
		
		if(head==null || head.next==null)
			return head;
		
		ListNode slow = head, fast = head, pre = null;
		
		while(fast!=null && fast.next!=null){
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		pre.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(slow);
		
		return merge(left, right);
	}

	
	private static ListNode merge(ListNode l1, ListNode l2){
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		
		
		if(l2.data < l1.data){
			ListNode temp = l1;
			l1 = l2;
			l2 = temp;
		}
		ListNode head=l1;

		while(l1.next!=null){
			ListNode next= l1.next;
			
			if(next.data<=l2.data){
				l1 = next;
			}else{
				l1.next = l2;
				l1 = l2;
				l2 = next;
			}
		}
		l1.next = l2;
		
		return head;
	}
	
	
}
