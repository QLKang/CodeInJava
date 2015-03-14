package leetcode.linkedlist.rotatelist;

/*
 * test case null || n==0, return head;
 * if n is a mutilple of len, then n = n%len. If n ==0 return head;
 * 
 * 
 */

public class RotateList {
	public static ListNode rotateRight(ListNode head, int n){
		if(head==null || n==0)
			return head;
		
		ListNode r = head;
		int len = 0;
		while(r!=null){
			len++;
			r = r.next;
		}
		
		ListNode r1 = head, r2 = head;
		int cnt = n%len;
		if(cnt==0 )
			return head;
		while(cnt>0){
			r2 = r2.next;
			cnt--;
			if(r2 == null)
				return head;
		}
		
		if(r2 == head) return head;
		
		while(r2.next!=null){
			r1 = r1.next;
			r2 = r2.next;
		}
		
		ListNode F = new ListNode(0);
		F.next = r1.next;
		r1.next = null;
		r2.next = head;
	
		return F.next;
	}
	
//	public static ListNode rotateRight(ListNode head, int n){
//		if(head==null || n==0)
//			return head;
//		
//		int cnt = n;
//		ListNode r1 = head, r2 = head;
//		while(cnt > 0){
//			r2 = r2.next;
//			cnt--;
//			if(r2==null){ // if n>lenght return error.
//				r2 = head;
//			}
//		}
//
//		if(r2==head) return head; // n == the length of the linkedlist return the list
//		
//		while(r2.next!=null){
//			r1 = r1.next;
//			r2 = r2.next;
//		}
//		
//		ListNode F = new ListNode(0);
//		F.next = head;
//		F.next = r1.next;
//		r1.next = null;
//		r2.next = head;
//		
//		return F.next;
//	}

}
