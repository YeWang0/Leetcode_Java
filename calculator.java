import java.util.Queue;
import java.util.Stack;

/**
 * Created by yvan on 9/27/16.
 */
public class calculator {
    public  static  void main(String [] args){
        calculator c=new calculator();
        int x=c.calculate("2*3+4");
        System.out.println(x);
    }
    public int calculate(String s){
        Stack<Integer> numbers=new Stack<Integer>();
        Stack<Character> operators=new Stack<Character>();
        if(s.charAt(s.length()-1)!=' '){
            s+=' ';
        }
        int temp=0;
        int a,b;
        char op=' ';
        boolean flag=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<='9' && s.charAt(i)>='0'){
                temp=temp*10+(int)(s.charAt(i)-'0');
                System.out.println(temp);
            }else{
                if(s.charAt(i)!=' ' || s.charAt(i)==' ' && i==s.length()-1) {
                    if (flag) {
                        b = temp;
                        a = numbers.pop();
                        if (op == '*') {
                            numbers.push(a * b);
                        } else if (op == '/') {
                            numbers.push(a / b);
                        }
                        flag = false;
                        op = ' ';
                    }else{
                        numbers.push(temp);
                    }
                    if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                        flag = true;
                        op = s.charAt(i);
                    } else if (s.charAt(i) != ' ') {
                        operators.push(s.charAt(i));
                    }
                    temp = 0;
                }
            }
        }
        a=numbers.get(0);
        int i=0;
        int j=1;
        while (i<operators.size() || j<numbers.size()){
            op=operators.get(i);
            i++;
            b=numbers.get(j);
            j++;
            if(op=='+'){
                a+=b;
            }
            else if(op=='-'){
                a-=b;
            }
        }
        return a;
    }
}
