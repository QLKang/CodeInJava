package leetcode.linkedlist.reversenodesinkgroup;

public class TestRK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		ListNode a7 = new ListNode(7);

		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;

		int k = 3;
		ListNode res = ReverseNodesInKGroup.reverseKGroup(a1, k);
		while (res != null) {
			System.out.print(res.data);
			res = res.next;
		}

	}

}
/*
 * for the case k>=len, we need to discuss it with the interviewer 
 * test case:
 * {1}, 2, return {1} 
 * {1, 2}, 3, return {1,2} 
 * {1, 2}, 2, return {2, 1}
 */