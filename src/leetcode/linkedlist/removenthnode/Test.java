package leetcode.linkedlist.removenthnode;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);

		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		
		int n = 9;
		ListNode res = RemoveNthNode.removeNthFromEnd(a1, n);
		while(res!=null){
			System.out.print(res.data+" ");
			res = res.next;
		}
	}

}
