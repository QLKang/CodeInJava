/**
 * 
 */
package leetcode.linkedlist.addtwonums;

import leetcode.linkedlist.sortlist.ListNode;

/**
 * @author ring
 * @version 030715
 */
public class AddTwoNums {

	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		if(l1==null) return l2;
		if(l2==null) return l1;
		
		int carry=0;
		ListNode Res = new ListNode(0);
		ListNode curr = Res;
		while(l1!=null || l2!=null){
			int r = (l1==null? 0: l1.data)+(l2==null?0:l2.data)+carry;
			int reminder = r%10;
			carry = r/10;
			
			curr.next = new  ListNode(reminder);
			curr = curr.next;

			if(l1!=null)
				l1 = l1.next;
			if(l2!=null)
				l2 = l2.next;
		}
		if(carry!=0){
			curr.next = new ListNode(carry);
		}
		return Res.next;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(5);
		
		ListNode a3 = new ListNode(6);
		
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		
		a1.next=a2;a2.next=a3;//a3.next=a4;
		a4.next=a5;a5.next=a6;
		
		ListNode res = AddTwoNums.addTwoNumbers(a1, a4);
		while(res!=null){
			System.out.print(res.data);
			res = res.next;
		}
	}

}
