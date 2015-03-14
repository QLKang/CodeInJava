/**
 * 
 */
package leetcode.linkedlist.partitionlist;

/**
 * @author ring Update: time Mar.5, 2015 *
 *         ��������˵����һ��x��ֵ��С��x�����ڴ��ڵ���x��ǰ�棬���Ҳ��ı�����֮��nodeԭʼ�����λ��
 *         ��ÿ�ο���������������Σ�����Ϊʲô4��3��ǰ�档����ʵ���ǵ�������⣬4->3->5���Ǵ��ڵ�3�����������Ᵽ��������ԭ�������λ�� ��
 */
public class PatitionList {

	public static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode list1 = new ListNode(0);
		ListNode list2 = new ListNode(0);

		ListNode pre1 = list1, pre2 = list2;
		ListNode curr = head, next = null;

		while (curr != null) {
			next = curr.next;
			if (curr.data < x) {
				pre1.next = curr;
				pre1 = curr;
			} else {
				pre2.next = curr;
				pre2 = curr;
			}

			curr = next;
		}
		pre2.next = null;
		pre1.next = list2.next;

		return list1.next;
	}

	/**
	 * @param args
	 *            test case: 1->4->3->2->5->2 and x = 3, return
	 *            1->2->2->4->3->5.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(2);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(2);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		ListNode res = PatitionList.partition(a1, 3);
		while (res != null) {
			System.out.print(res.data + " ");
			res = res.next;
		}
	}
}
