/**
 * 
 */
package leetcode.linkedlist.mergeksortedlist;

import java.util.ArrayList;
import java.util.List;

import leetcode.linkedlist.sortlist.ListNode;

/**
 * @author ring
 * @version 030515
 */
public class MergeKSortedList {

	public static ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;

		return helper(lists, 0, lists.size()-1);
	}

	private static ListNode helper(List<ListNode> lists, int start, int end) {
		if (start == end) {
			return lists.get(start);
		}
		if (start < end) {
			int mid = (end - start) / 2 + start;
			ListNode l1 = helper(lists, start, mid);
			ListNode l2 = helper(lists, mid+1, end);
			return merge(l1, l2);
		}
		return null;
	}
	
	
	private static ListNode merge(ListNode l1, ListNode l2){
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		
		ListNode FH = new ListNode(0);
		if(l1.data > l2.data){
			ListNode temp = l1;
			l1 = l2;
			l2 = temp;
		}
		
		FH.next = l1;
		while(l1.next != null){
			ListNode next = l1.next;
			if(next.data <= l2.data){
				l1 = l1.next;
			}else {
				l1.next = l2;
				l1 = l2;
				l2 = next;
			}
		}
		
		l1.next = l2;
		
		return FH.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(3);
		ListNode a3 = new ListNode(9);
		ListNode a4 = new ListNode(10);
		
		ListNode b1 = new ListNode(4);
		ListNode b2 = new ListNode(6);
		ListNode b3 = new ListNode(7);
		
		
		ListNode c1 = new ListNode(3);
		ListNode c2 = new ListNode(4);
		ListNode c3 = new ListNode(9);
		ListNode c4 = new ListNode(10);
		ListNode c5 = new ListNode(13);
		
		a1.next=a2;a2.next=a3;a3.next=a4;
		b1.next=b2;b2.next=b3;
		c1.next=c2;c2.next=c3;c3.next=c4;c4.next=c5;
		
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(a1);
		lists.add(b1);
		lists.add(c1);
		
		ListNode res = mergeKLists(lists);
		while(res!=null){
			System.out.print(res.data+" ");
			res = res.next;
		}
	}

}
