/**
 * Created by yvan on 9/20/16.
 */
public class ReverseLinkedList {
    public ListNode reverse(ListNode head){
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode temp;
        ListNode temp2;
        ListNode p=head;
        while(p.next!=null){
            temp=p.next;
            temp2=temp.next;
            temp.next=pre.next;
            pre.next=temp;
            p.next=temp2;
        }
        return pre.next;
    }
}
