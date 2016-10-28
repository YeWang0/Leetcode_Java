/**
 * Created by yvan on 10/27/16.
 */
public class ReverseString {
    public String reverseString(String s) {
        int n=s.length();
        char [] str=s.toCharArray();
        char temp;
        for(int i=0;i<n/2;i++){
            temp=str[i];
            str[i]=str[n-i-1];
            str[n-i-1]=temp;
        }
        return new String(str);
    }
}
