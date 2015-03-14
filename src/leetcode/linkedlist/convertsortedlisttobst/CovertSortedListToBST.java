package leetcode.linkedlist.convertsortedlisttobst;

import leetcode.linkedlist.sortlist.ListNode;
/***
 * @author ring
 * @version 030715
 */
public class CovertSortedListToBST {
	public static TreeNode sortedListToBST(ListNode head) {

		if (head == null)
			return null;
		if (head.next == null) {
			return new TreeNode(head.data);
		}

		// more than one node in list
		ListNode slow = head, fast = head, pre = null;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		TreeNode root = new TreeNode(slow.data);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(slow.next);

		return root;
	}

	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		
		a1.next=a2;a2.next=a3;a3.next=a4;a4.next=a5;a5.next=a6;
		TreeNode res = CovertSortedListToBST.sortedListToBST(a1);
		System.out.println(res.data);
		
	}

}