/**
 * Created by yvan on 11/22/16.
 */
public class LinkedListCycle2 {
    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode pre=head;
        while(slow!=null&&fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)break;
        }
//        while(slow!=null&&fast!=null){
//            pre=slow;
//            if(slow==fast)return pre;
//            slow=slow.next;
//            fast=fast.next;
//
//        }
//        return null;
        if(slow!=fast||slow==null||fast==null||fast.next==null)return null;
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
