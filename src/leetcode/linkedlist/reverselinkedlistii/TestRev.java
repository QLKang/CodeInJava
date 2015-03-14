package leetcode.linkedlist.reverselinkedlistii;

public class TestRev {

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
		
		int m = 2, n = 4;
		ListNode res = ReverseLinkedListII.reverseBetween(a1, m, n);
		while(res!=null){
			System.out.print(res.data);
			res = res.next;
			
		}
		
		
		
		
	}

}
