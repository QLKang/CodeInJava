/**
 * 
 */
package leetcode.linkedlist.linkedlistcycle;

import leetcode.linkedlist.sortlist.ListNode;

/**
 * @author ring
 *
 */
public class LinkedListCycle {

	public boolean hasCycle(ListNode head){
		if(head==null)
			return false;
		
		ListNode slow = head, fast = head;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow ==fast)
				return true;
		}
		
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
