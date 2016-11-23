/**
 * Created by yvan on 11/22/16.
 */
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // if(m>n){
        //     int t=m;
        //     m=n;
        //     n=t;
        // }
        ListNode pre=new ListNode(0);
        pre.next=head;
        while(m<n){
            reverse(pre,m++,n--);
        }
        return pre.next;
    }
    public void reverse(ListNode pre, int m,int n){

        int count=1;

        ListNode p1=pre;
        while(count<m){
            p1=p1.next;
            count++;
        }
        ListNode p2=p1;
        while(count<n){
            p2=p2.next;
            count++;
        }

        ListNode temp;
        ListNode n1=p1.next;
        ListNode n2=p2.next;
        if(n1==p2){
            temp=n2.next;
            p1.next=n2;
            n2.next=n1;
            n1.next=temp;
        }else{
            temp=n2.next;
            p1.next=n2;
            n2.next=n1.next;
            p2.next=n1;
            n1.next=temp;
        }
    }
}
