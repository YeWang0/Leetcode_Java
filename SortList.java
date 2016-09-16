/**
 * Created by yvan on 9/16/16.
 */

public class SortList {
    public ListNode sort(ListNode head){
        ListNode prev=head;
        ListNode slow=head;
        ListNode fast=head;
        if(head==null || head.next==null){
            return head;
        }
        while(slow!=null&&fast!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next;
            if(fast!=null)
                fast=fast.next;
            else
                break;
        }
        prev.next=null;
        ListNode l1=sort(head);
        ListNode l2=sort(slow);
        return merge(l1,l2);
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode l=new ListNode(0);
        ListNode pre=l;

        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                pre.next=l2;
                l2=l2.next;
            }else{
                pre.next=l1;
                l1=l1.next;
            }

            pre=pre.next;
        }
        if(l1==null){
            pre.next=l2;
        }else if(l2==null){
            pre.next=l1;
        }
        return l.next;
    }
}


