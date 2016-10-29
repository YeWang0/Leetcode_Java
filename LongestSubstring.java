import java.util.HashSet;

/**
 * Created by yvan on 10/26/16.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int head=0;
        HashSet<Character> set=new HashSet<>();
        int count=0;
        int max=0;
        for(int i=0;i<s.length();){
            if(!set.contains(s.charAt(i))){
                count++;
                set.add(s.charAt(i));
                if(max<count)max=count;
                i++;
            }else{
                if(set.contains(s.charAt(head)))
                    set.remove(s.charAt(head++));
                    count--;
            }
        }
        return max;
    }
}
