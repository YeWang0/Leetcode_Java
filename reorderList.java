import java.util.List;

/**
 * Created by yvan on 9/14/16.
 */
public class reorderList {
    public static void main(String [] args){
        ListNode pre=new ListNode(0);
        ListNode head=pre;
        for(int i=1;i<20;i++){
            ListNode node=new ListNode(i);
            pre.next=node;
            pre=node;
        }
//        pre.next=null;

        reorderList rl=new reorderList();

        rl.reorderList(head);
        for(int i=0;head!=null;i++){
            System.out.print(head.val+" ");
            head=head.next;
        }

    }
    public void reorderList(ListNode head) {
        ListNode p=head;
        ListNode q=head;
        if(head==null || head.next==null){
            return;
        }
        while(q.next!=null&&q.next.next!=null){
            p=p.next;
            q=q.next.next;
        }
//        System.out.println("p:"+p.val);
        q=reverse(p.next);
        p.next=null;
        p=head;
        ListNode temp;
        while (p!=null && q!=null){
            temp=q;
            q=q.next;
            temp.next=p.next;
            p.next=temp;
            p=p.next.next;
        }

    }
    public ListNode reverse(ListNode head){
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode temp;
        ListNode temp2;
        ListNode p=head;
        if(p==null){
            return null;
        }
        while(p.next!=null){
            temp=p.next;
            temp2=temp.next;
            temp.next=pre.next;
            pre.next=temp;
            p.next=temp2;
        }
        head=pre.next;
//        for(int i=0;head!=null;i++){
//            System.out.println(head.val);
//            head=head.next;
//        }
        return pre.next;
    }

    public ListNode backnode(ListNode node){
        ListNode head=node;
        ListNode pre=new ListNode(0);
        if(head.next==null){
            return null;
        }
        while(head.next!=null){
            pre=head;
            head=head.next;
        }
        head=pre.next;
        pre.next=null;
        return head;
    }

}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
