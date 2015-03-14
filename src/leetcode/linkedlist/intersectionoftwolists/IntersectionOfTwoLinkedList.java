package leetcode.linkedlist.intersectionoftwolists;

import leetcode.linkedlist.sortlist.ListNode;
/*Update: Mar.7, 2015, time O(n), space O(1)*/
public class IntersectionOfTwoLinkedList {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		int lenA = getLen(headA);
		int lenB = getLen(headB);

		if (lenA > lenB) {
			int cnt = 0;
			while (cnt < lenA - lenB) {
				headA = headA.next;
				cnt++;
			}
		} else if (lenA < lenB) {
			int cnt = 1;
			while (cnt < lenB - lenA) {
				headB = headB.next;
				cnt++;
			}
			headB = headB.next;
		}

		while (headA != null) {
			if (headA == headB)
				return headA;
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	private static int getLen(ListNode head) {
		int len = 0;
		while (head != null) {
			head = head.next;
			len++;
		}

		return len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(11);
		ListNode a2 = new ListNode(12);
		ListNode a3 = new ListNode(13);
		ListNode a4 = new ListNode(14);
		ListNode a5 = new ListNode(15);
		ListNode a6 = new ListNode(16);
		ListNode a7 = new ListNode(17);
		ListNode a8 = new ListNode(18);
		ListNode a9 = new ListNode(19);
		ListNode a10 = new ListNode(20);
		ListNode a11 = new ListNode(21);
		ListNode a12 = new ListNode(22);
		ListNode a13 = new ListNode(23);
		ListNode a14 = new ListNode(24);
		
		
		
		a1.next=a2;a2.next=a3;a3.next=a4;a4.next=a5;a5.next=a6;a6.next=a7;a7.next=a8;a8.next =a9;
		a9.next=a10;a10.next=a11;a11.next=a12;a12.next=a13;a13.next=a14;
		ListNode b1 = new ListNode(2);
		ListNode b2 = new ListNode(4);
		ListNode b3 = new ListNode(6);
		ListNode b4 = new ListNode(8);
		ListNode b5 = new ListNode(10);
		b1.next=b2;b2.next=b3;b3.next=b4;b4.next=b5;
		b5.next = a1;
		
		ListNode res = IntersectionOfTwoLinkedList.getIntersectionNode(a1, b1);
		System.out.println(res.data);
		
		
		
	}

}
