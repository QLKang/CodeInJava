/**
 * 
 */
package leetcode.linkedlist.copylistwithrandompointer;

import java.util.HashMap;

/**
 * @author ring
 * @version 030715
 */
public class CopyListWithRandomPointer {
	/*methodI: time: O(n), space O(n)*/
	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;

		RandomListNode r1 = head;
		RandomListNode next = null;
		while (r1 != null) {
			next = r1.next;
			RandomListNode newNode = new RandomListNode(r1.label);
			r1.next = newNode;
			newNode.next = next;
			r1 = next;
		}

		r1 = head;
		while (r1.next.next != null) {
			next = r1.next.next;
			RandomListNode random = r1.random;
			if (random != null)
				r1.next.random = random.next;
			r1 = next;
		}

		RandomListNode random = r1.random;
		if (random != null)
			r1.next.random = random.next;

		r1 = head;
		RandomListNode r2 = r1.next;
		RandomListNode newHead = r2;
		while (r1.next.next != null) {
			r1.next = r2.next;
			r1 = r1.next;

			r2.next = r1.next;
			r2 = r2.next;
		}
		r1.next = null;

		return newHead;
	}
/*methodII: hashmap time: O(n), space O(n)*/
	public static RandomListNode copyRandomListI(RandomListNode head) {
		if (head == null)
			return null;

		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode curr = head;
		while (curr != null) {
			RandomListNode newNode = new RandomListNode(curr.label);
			map.put(curr, newNode);
			curr = curr.next;
		}

		curr = head;
		while (curr != null) {
			if (curr.next != null)
				map.get(curr).next = map.get(curr.next);
			if (curr.random != null)
				map.get(curr).random = map.get(curr.random);
			curr = curr.next;
		}

		return map.get(head);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode a1 = new RandomListNode(-1);
		RandomListNode a2 = new RandomListNode(1);
		a1.next = a2;
		RandomListNode res = CopyListWithRandomPointer.copyRandomList(a1);
		System.out.println(res.label);
	}

}
