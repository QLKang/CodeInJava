package leetcode.linkedlist.linkedlistcycle;

import leetcode.linkedlist.sortlist.ListNode;

public class DetectCycle {
	public static ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;

		ListNode fast = head, slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		if (slow == fast) {
			fast = head;
			while (fast != slow) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		} else {
			return null;
		}

	}
	
	
	
	public static void main(String[] args){
		ListNode head = new ListNode(3);
		head.next = head;
		ListNode res = DetectCycle.detectCycle(head);
		System.out.println(res.data);
		
	}
}
