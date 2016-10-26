import java.util.HashMap;

/**
 * Created by yvan on 10/25/16.
 */
public class checkAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                if(map.get(t.charAt(i))>0){
                    map.put(t.charAt(i),map.get(t.charAt(i))-1);
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
