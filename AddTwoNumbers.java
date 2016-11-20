import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by yvan on 11/20/16.
 */

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> n1 = new Stack<>();
        Stack<Integer> n2 = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        while (l1!=null){
            n1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            n2.push(l2.val);
            l2=l2.next;
        }
        int carry=0;
        int p;
        int q;
        int sum;
        int t;
        while(!n1.isEmpty()||!n2.isEmpty()) {

            p=n1.isEmpty()?0:n1.pop();
            q=n2.isEmpty()?0:n2.pop();
            sum=p+q+carry;
            t=sum%10;
            carry=sum/10;
            result.add(t);
        }
        if(carry>0){
            result.add(carry);
        }
        ListNode node=new ListNode(0);
        ListNode temp;
        for(int i:result){
            temp=node.next;
            node.next=new ListNode(i);
            node.next.next=temp;
        }
        return node.next;
    }
}
