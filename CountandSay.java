/**
 * Created by yvan on 10/28/16.
 */
public class CountandSay {
    public static void main(String [] args){
        CountandSay cs=new CountandSay();
        System.out.println(cs.countAndSay(1121));
    }

    public String countAndSay(int n) {
        String out="1";
        for(int i=1;i<n;i++){
            out=say(out);
            // System.out.println(out);
        }
        return out;
    }
    public String say(String num) {
//        String num=String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        int count=1;
        char pre=num.charAt(0);
        for(int i=1;i<num.length();i++){
            if(num.charAt(i)==pre){
                count++;
            }else{
                // output+=(char)(count+48)+""+pre;
                sb.append(count);
                sb.append(pre);
                pre=num.charAt(i);
                count=1;
            }
        }
        // output+=(char)(count+48)+""+pre;
        sb.append(count);
        sb.append(pre);
        return sb.toString();
    }
}
