import java.util.Stack;

/**
 * Created by yvan on 9/6/16.
 */
public class DecodeString {
    public static void main(String [] args){
        DecodeString ds=new DecodeString();
        ds.decode("2[abc]df3[cd]ef");
    }

    public String decode(String input){
        if(input.length()<=1){
            return input;
        }
        Stack<Character> stack=new Stack<Character>();
        stack.push(input.charAt(0));
        int i=1;

        while(i<input.length()){
            if(input.charAt(i)!=']'){
                stack.push(input.charAt(i));
                i++;
            }else{
                i++;
                String sub="";
                //pop out the substring between []
                while(!stack.isEmpty()){
                    Character c=stack.pop();
                    if(c=='['){
                        break;
                    }else{
                        sub=c+sub;
                    }
                }
                //pop out the number
                String num="";
                while(!stack.isEmpty()){
                    Character c=stack.pop();
                    if(c>='0' && c<='9'){
                        num=c+num;
                    }else{
                        stack.push(c);
                        break;
                    }
                }
                System.out.println(num);
                int number=Integer.parseInt(num);
                System.out.println(number);

                String result="";
                for(int j=0;j<number;j++){
                    result+=sub;
                }

                System.out.println(result);
                for(int x=0;x<result.length();x++){
                    stack.push(result.charAt(x));
                }
            }
        }
        String result="";
        while(!stack.isEmpty()){
            result=stack.pop()+result;
        }
        System.out.println(result);
        return result;
    }
}
