import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by yvan on 10/25/16.
 */
public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
            else if(set.contains(t.charAt(i))){
                return false;
            }
            else{
                map.put(s.charAt(i),t.charAt(i));
                set.add(t.charAt(i));
            }
        }
        return false;
    }
}
