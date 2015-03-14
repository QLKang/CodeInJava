package leetcode.linkedlist.reorderlist;

public class TestRL {

	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		
		a1.next = a2;
//		a2.next = a3;
//		a3.next = a4;
//		a4.next = a5;
		
		ReorderList.reorderListII(a1);
		
		while(a1!=null){
			System.out.print(a1.data);
			a1 = a1.next;
		}
	}
}
