/**
 * 
 */
package leetcode.linkedlist.mergelist;

import leetcode.linkedlist.sortlist.ListNode;

/**
 * @author ring
 * @version 030515
 */
public class MergeLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		
		ListNode FH = new ListNode(0);
		if(l1.data > l2.data){
			ListNode temp = l1;
			l1 = l2;
			l2 = temp;
		}
		FH.next = l1;
		
		while(l1.next!=null){
			ListNode next = l1.next;
			if(next.data <= l2.data){
				l1 = l1.next;
			}else{
				l1.next = l2;
				l1 = l2;
				l2 = next;
			}
		}
		l1.next = l2;
		
		return FH.next;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		
		ListNode a4 = new ListNode(2);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(2);
		a1.next = a2;
		a2.next = a3;
//		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		
		ListNode res = mergeTwoLists(a1, a4);
	}

}
