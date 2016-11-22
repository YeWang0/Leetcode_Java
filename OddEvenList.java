/**
 * Created by yvan on 11/20/16.
 */
public class OddEvenList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode oddEvenList(ListNode head) {
        int count=0;
        ListNode node=head;
        ListNode pre=head;
        while(node!=null&&node.next!=null){
            count++;
            node=node.next;
        }
        if(count<=1)return head;
        count=(count+1)/2;
        while(count>0) {
            node.next = pre.next;
            pre.next = pre.next.next;
            pre = pre.next;
            node = node.next;
            node.next = null;
        }
        return head;
    }
}
