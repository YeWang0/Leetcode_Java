import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by yvan on 11/8/16.
 */
public class DecodeString2 {
    public String decodeString(String s) {
        Stack<Character> stack=new Stack<>();
        ArrayList<Character> sub=new ArrayList<>();
        Stack<Character> num=new Stack<>();
        int i=0;
        StringBuffer result=new StringBuffer();
        while(i<s.length()) {
            if (s.charAt(i) != ']') {
                stack.add(s.charAt(i));
                i++;
            } else {
                char temp = stack.peek();
                while (!stack.isEmpty() && temp >= 'a' && temp <= 'z') {

                    sub.add(stack.pop());
                    temp=stack.peek();
                }

                // for(int x=0;x<sub.size();x++){
                //     System.out.println(sub.get(x));
                // }

                if (stack.pop() != '[') return "Error";
                temp = stack.peek();
                while (!stack.isEmpty() && temp >= '0' && temp <= '9') {

                    num.add(stack.pop());
                    if(stack.isEmpty())break;
                    temp=stack.peek();
                }
                // stack.add(temp);

                int number = 0;
                while (!num.isEmpty()) {
                    number = number * 10 + (num.pop() - '0');
                }
                while (number > 0) {
                    int size = sub.size();
                    for (int j = size - 1; j >= 0; j--)
                        stack.add(sub.get(j));
                    number--;
                }
                sub=new ArrayList<>();
                i++;
            }
        }
        for(i=0;i<stack.size();i++){
            result.append(stack.get(i));
        }
        return result.toString();
    }
}
