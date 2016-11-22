/**
 * Created by yvan on 11/20/16.
 */
public class ReorderLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
        public void reorderList(ListNode head) {
            if (head == null) return;
            int count = 0;
            ListNode node = new ListNode(0);
            node.next = head;
            ListNode slow = node;
            ListNode fast = node;
            ListNode curr;
            ListNode precurr;
            ListNode temp;
            ListNode temp2;
            while (slow != null && fast != null && fast.next != null) {
//            preslow=slow;
                count++;
                slow = slow.next;
                fast = fast.next.next;
            }
            if (count <= 1) return;
            precurr = slow.next;
            curr = slow.next.next;

            while (curr != null) {
                temp = slow.next;
                slow.next = curr;
                precurr.next = curr.next;
                curr.next = temp;
                curr = precurr.next;
            }

            while (slow.next != null && head != null) {
                temp = slow.next;
                slow.next = temp.next;
                temp2 = head.next;
                head.next = temp;
                temp.next = temp2;
                head = temp2;
            }
        }
}
