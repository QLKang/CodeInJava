package leetcode.linkedlist.removedup;

/*SolIII update: Mar.4, 2015*/
public class RemoveDup {
	final static ListNode FH= new ListNode(0);
	public static ListNode deleteDuplicates(ListNode head){
		
		if(head==null || head.next == null)
			return head;
		FH.next = head;
		ListNode pre = FH, curr = head, next = null;
		
		while(curr.next!=null){
			next = curr.next;
			if(curr.data == next.data){
				pre.next = next;
				curr = next;
			}else{
				pre = curr;
				curr = next;
			}
		}
		
		return FH.next;
	}
	
	public static void main(String[] arg){
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(5);
		ListNode a4 = new ListNode(5);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(5);
		ListNode a7 = new ListNode(5);
		ListNode a8 = new ListNode(5);
		a1.next = a2;
//		a2.next = a3;
//		a3.next = a4;
//		a4.next = a5;
//		a6.next = a7;
//		a7.next = a8;
		ListNode res = RemoveDup.deleteDuplicates(a1);
		while(res!=null){
			System.out.print(res.data+" ");
			res = res.next;
		}
		
	}
	
	
}
