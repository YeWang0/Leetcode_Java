import java.util.HashMap;
import java.util.Map;

/**
 * Created by yvan on 10/21/16.
 */
public class longestPalindrome {
    public int getLongestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int odd=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
//            Character key = entry.getKey();
            Integer value = entry.getValue();
            if(value%2==0){
                max+=value;
            }else{
                max+=value-1;
                odd=1;
            }
        }
        return max+odd;
    }
}
