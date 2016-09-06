/**
 * Created by yvan on 9/5/16.
 */
public class Subsequence {
    public static void main(String [] atrgs){
        Subsequence ss=new Subsequence();
        System.out.println(ss.isSubsequence("abc","ahbgdc"));
    }
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        if(t.length()<s.length()){
            return false;
        }
        for(int i=0,j=0;i<t.length();i++){

            if(s.charAt(j)==t.charAt(i)) {
                j += 1;
            }
            if(j==s.length()){
                return true;
            }
        }
        return false;
    }
}
