import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by yvan on 10/25/16.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] parts = str.split(" ");
        HashMap<Character,String> map=new HashMap<>();
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!parts[i].equals(map.get(pattern.charAt(i)))){
                    return false;
                }
            }
            else if(set.contains(parts[i])){
                return false;
            }
            else{
                map.put(pattern.charAt(i),parts[i]);
                set.add(parts[i]);
            }
        }
        return true;
    }
}
