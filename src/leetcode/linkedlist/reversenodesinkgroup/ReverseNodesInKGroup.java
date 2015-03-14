package leetcode.linkedlist.reversenodesinkgroup;

public class ReverseNodesInKGroup {	
	static ListNode Pre = null;
	
	public static ListNode reverseKGroup(ListNode head, int k){
		if(head==null ||k==0||k==1||k<0)
			return head;
		
		int len = 0;
		ListNode r = head, end = null;
		while(r!=null){
			len++;
			end = r;
			r = r.next;
		}

		ListNode FH = new ListNode(0);
		FH.next = head;
		Pre = FH;
		
		if(k>len){
			return head;
		}
		if(k==len){
			reverse(Pre, end);
			return FH.next;
		}
		
		// k<len
		int segment = len/k; //the linked list is split into several segments which are always larger than 1
		int cnt = 1, seg = 1;
		r = head;
		while(cnt<=seg*k && seg <=segment){
			if(cnt==seg*k){
				ListNode newSubHead = r.next;
				reverse(Pre, r); // update pre in reverse() method
				Pre.next = newSubHead;
				r = Pre;
				seg++;
			}
			r = r.next;
			cnt++;
		}
		
		return FH.next;
	}
	
	private static void reverse(ListNode lastEnd, ListNode end){ // since k is alway lareger than 1, the sublen if larger than 1.
		// update pre
		Pre = lastEnd.next; 
		// keep the last end of last sub linkedlist
		ListNode pp = lastEnd;
		ListNode curr = lastEnd.next, next = null;
		// there are at least one node in the list, curr/head could not be null;
		while(curr!=end){
			next = curr.next;
			curr.next = pp;
			pp = curr;
			curr = next;
		}
		curr.next = pp;
		lastEnd.next = curr;
		Pre.next = null;
	}
	
}
