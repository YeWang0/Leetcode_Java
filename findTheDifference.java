import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yvan on 9/14/16.
 */
public class findTheDifference {
    public char find(String s, String t) {
        HashMap<Character,Integer> hashMap=new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            if(!hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i),1);
            }else{
                hashMap.put(s.charAt(i),hashMap.get(s.charAt(i))+1);
            }
        }
        for(int i=0;i<t.length();i++){
            if(!hashMap.containsKey(t.charAt(i))){
                hashMap.put(t.charAt(i),-1);
            }else{
                hashMap.put(t.charAt(i),hashMap.get(t.charAt(i))-1);
            }
        }
        Iterator iter = hashMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();

            if((int)entry.getValue()<0){
                return (char)entry.getKey();
            }
        }
        return ' ';
    }
}
