/**
 * Created by yvan on 10/31/16.
 */
public class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        int min=Integer.MAX_VALUE;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(min>strs[i].length())min=strs[i].length();
        }
        for(int i=0;i<min;i++){
            for(int j=0;j<n-1;j++){
                if(strs[j].charAt(i)!=strs[j+1].charAt(i))return sb.toString();
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}
