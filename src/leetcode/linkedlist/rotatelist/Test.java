package leetcode.linkedlist.rotatelist;

public class Test {

	public static void main(String[] args){
		
		
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		ListNode a7 = new ListNode(7);
		ListNode a8 = new ListNode(8);
		
		
		
		
		a1.next=a2;a2.next=a3;a3.next=a4;a4.next=a5;
//		a5.next = a6;
//		a6.next = a7;
//		a7.next = a8;
//		
		
		ListNode res = RotateList.rotateRight(a1, 2000000000);
		while(res!=null){
			System.out.print(res.data);
			res = res.next;
		}
		
	}
}
