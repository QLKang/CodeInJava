package leetcode.linkedlist.removedupii;
/* SolIII update Mar.5, 2015 */
public class RemoveDupII {

	final static ListNode FH = new ListNode(0);

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		FH.next = head;
		ListNode pre = FH, curr = null, temp = head;
		curr = temp.next; // inital state curr is not null, since
							// head.next!=null
		int cnt = 1; // cnt is the number of some duplicated nodes
		while (curr != null) {
			if (curr.data == temp.data) {
				cnt++;
				curr = curr.next;
			} else {
				if (cnt == 1) { // the temp code is unique. Do not delete any
								// nodes.
					pre = temp;
					temp = curr;
					curr = curr.next;
				} else { // the temp code is not unique. Delete all the codes
							// having the same value with temp code.
					pre.next = curr;
					temp = curr; // reset new temp which might be a beginning
									// node of several duplicated nodes being
									// same with temp.data
					cnt = 1; // the inital number of temp node is 1.
					curr = curr.next;
				}
			}
			/*
			 * this case means the last several codes have the same value. e.g.
			 * 1--2--3--3--3
			 */
			if (cnt > 1) {
				pre.next = curr;
			}
		}

		return FH.next;
	}

	/*--test--*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(1);
		ListNode a3 = new ListNode(1);
		ListNode a4 = new ListNode(5);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		ListNode a7 = new ListNode(6);
		ListNode a8 = new ListNode(7);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a6.next = a7;
		a7.next = a8;
		ListNode res = RemoveDupII.deleteDuplicates(a1);
		while (res != null) {
			System.out.print(res.data + " ");
			res = res.next;
		}

	}

} // end class
