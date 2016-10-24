import java.util.HashMap;

/**
 * Created by yvan on 10/24/16.
 */
public class BullandCow {
    public String getHint(String secret, String guess) {
        int x=secret.length();
        int y=guess.length();
        int n=Math.min(x,y);
        int bull=0;
        int cow=0;
        HashMap<Character,Integer> smap=new HashMap<>();
        for(int i=0;i<n;i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bull++;
            }
        }

        cow-=bull;

        for(int i=0;i<x;i++){
            if(smap.containsKey(secret.charAt(i))){
                smap.put(secret.charAt(i),smap.get(secret.charAt(i))+1);
            }else{
                smap.put(secret.charAt(i),1);
            }
        }
        for(int i=0;i<y;i++){
            if(smap.containsKey(guess.charAt(i))&&smap.get(guess.charAt(i))>0){
                cow++;
                smap.put(guess.charAt(i),smap.get(guess.charAt(i))-1);
            }
        }
        return Integer.toString(bull)+'A'+Integer.toString(cow)+'B';
    }
}
