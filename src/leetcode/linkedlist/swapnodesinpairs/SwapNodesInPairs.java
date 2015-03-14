package leetcode.linkedlist.swapnodesinpairs;

public class SwapNodesInPairs {
	
	public static ListNode swapPairs(ListNode head){
		if(head==null || head.next==null)
			return head;
		
		ListNode F = new ListNode(0);
		ListNode pre = F;
		ListNode curr = head, next, temp;
		pre.next = curr;
		
		while(curr!=null && curr.next!=null){
			next = curr.next;
			temp = next.next;
			
			curr.next = temp;
			next.next = curr;
			pre.next = next;
			pre = curr;
			curr = temp;
		}
		
		return F.next;
	}
}
