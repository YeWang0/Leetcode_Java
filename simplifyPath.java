import java.util.Stack;

/**
 * Created by yvan on 9/27/16.
 */
public class simplifyPath {
    public static void main(String [] args){
        simplifyPath sp=new simplifyPath();
        sp.simplify("/mpJN/..///../../ubYgf/tFM/");
    }
    public String simplify(String s){
        Stack<String> stack=new Stack<>();
        String temp="";
        stack.push("/");
        if(s.charAt(s.length()-1)!='/'){
            s+="/";
        }
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='/'){
                temp+='/';
                // System.out.println("temp="+temp);
                if(temp.equals("./")){
                    temp="";
                }else if(temp.equals("../")){
                    if(stack.size()>1)
                        stack.pop();
                    temp = "";
                }else if(temp.equals("/")) {
                    if(stack.size()==0  ){
                        stack.push(temp);
                        temp = "";
                    }else{
                        temp = "";
                    }
                }else{
                    stack.push(temp);
                    temp = "";
                }
            }
            else{
                temp+=s.charAt(i);
            }
        }
        // System.out.println(temp);
        // if(!temp.equals("") && !temp.equals(".") && !temp.equals("..")){
        //     stack.push(temp);
        // }

        for(int i=0;i<stack.size();i++){
//            System.out.println(stack.get(i));
            temp+=stack.get(i);
        }
        int n=temp.length()-1;
        while(n>0){
            if(temp.charAt(n)=='/'){
                temp=temp.substring(0,n);
                n--;
            }else{
                break;
            }
        }
        return temp;
    }
}
