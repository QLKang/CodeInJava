package leetcode.linkedlist.reverselinkedlistii;


public class ReverseLinkedListII {
	// fake head which is reference to the head of linked list
	final static ListNode FH = new ListNode(0);
	
	public static ListNode reverseBetween(ListNode head, int m, int n){
		if(head==null||m==n)
			return head;
		
		// since 1<=m<=n<=length, we have m < n
		FH.next = head;
		// headM is the node which located at mth position.It is always the head of the sub reverse linkedlist
		ListNode headM = head;
		
		// pre is used to save the previous node of headM which is the head of reversed part
		ListNode pre = FH;
		ListNode curr = head, next = null, temp = null;
		int cnt = 1; // the initial curr==head, cnt==1. curr is always the reversed part's tail. headM is always the head of the reversed part
		
		// find the head of reversed part: headM
		while(cnt < m){
			pre = curr;
			curr = curr.next;
			cnt++;
		}
        // cnt == m
		headM = curr; // this curr node never changed. It is the node located in mth position in original linkedlist, it also is the tail of the reverse part
		
		while(cnt < n){
			
			next = curr.next;
			cnt++;
			// temp is used to mark the next node of next pointer. to make sure we will not lose the next.next
			temp = next.next;
			next.next = headM;
			headM = next; // each loop we need to update the next as new headM, and the tail is always the same node curr (which is located in mth position in original linkedlist)
			curr.next = temp;
			pre.next = headM;
		}

		return FH.next;
	} // end method

} // end class
