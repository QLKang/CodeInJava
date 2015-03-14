package leetcode.linkedlist.insertionsort;

import leetcode.linkedlist.sortlist.ListNode;
/**
 * @version 030715. Time O(n^2), space O(1)
 * **/
public class InsertionSortList {
	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode FH = new ListNode(0);
		FH.next = head;
		ListNode pre1 = FH, curr1 = head, pre2 = head, curr2 = head.next, next2 = null;

		while (curr2 != null) {
			next2 = curr2.next;
			
			if (curr2.data < curr1.data) {
				curr2.next = curr1;
				pre1.next = curr2;
				pre2.next = next2;

				curr2 = next2;
				pre1 = FH;
				curr1 = pre1.next;
			} else { // curr2.data>=curr1.data || curr2==curr1
				while (curr2.data >= curr1.data && curr1 != curr2) {
					pre1 = curr1;
					curr1 = curr1.next;

				}
				if (curr1 == curr2) {
					pre2 = curr2;
					curr2 = next2;

					pre1 = FH;
					curr1 = pre1.next;
				}
			}
		}

		return FH.next;
	}

	public static void main(String[] arg) {
		ListNode a1 = new ListNode(4);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(1);
		ListNode a5 = new ListNode(5);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;

		ListNode res = InsertionSortList.insertionSortList(a1);
		while (res != null) {
			System.out.print(res.data + "|");
			res = res.next;
		}
	}
}
