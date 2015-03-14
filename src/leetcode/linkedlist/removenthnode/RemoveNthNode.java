package leetcode.linkedlist.removenthnode;

/* SolII: Update Mar.4, 2015 one pass */
public class RemoveNthNode {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n<=0) {
			return head;
		}

		ListNode FH = new ListNode(0);
		FH.next = head;
		ListNode pre = FH, curr = head, next = head;
		int cnt = 1;

		while (cnt < n) {
			next = next.next;
			if (next == null) {
				System.out.println("Error.");
				return null;
			}
			cnt++;
		}

		while (next.next != null) {
			pre = curr;
			curr = curr.next;
			next = next.next;
		}
		// if n = 1, next == curr, delete the last node is OK.
		pre.next = curr.next;

		return FH.next;
	}
}
