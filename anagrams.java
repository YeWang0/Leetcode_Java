/**
 * Created by yvan on 10/24/16.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
public class anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int n=p.length();
        int tn=s.length();
        HashMap<Character,Integer> map=new HashMap<>();

        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<tn-n+1;i++) {

            for(int t=0;t<n;t++){
                if(!map.containsKey(p.charAt(t))){
                    map.put(p.charAt(t),1);
                }else {
                    map.put(p.charAt(t),map.get(p.charAt(t))+1);
                }
            }

            for (int j = 0; j <= n; j++) {
                if (j==n){
                    result.add(i);
                    break;
                }
                if (!map.containsKey(s.charAt(i+j))){
                    break;
                }else{
                    if(map.get(s.charAt(i+j))<=0){
                        break;
                    }else{
                        map.put(s.charAt(i+j),map.get(s.charAt(i+j))-1);
                    }
                }
            }
        }
        return result;
    }
}
