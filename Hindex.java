import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by yvan on 10/25/16.
 */
public class Hindex {
    public int hIndex(int[] citations) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=citations.length;
        Arrays.sort(citations);
        int max=0;
        for(int i=0;i<n;i++){
            if(citations[i]!=citations[i-1]){
//                n-i papers>citations[i]
                int threshhode=i>0?Math.max(citations[i-1]+1,Math.min(n-i,citations[i])):Math.min(n-i,citations[i]);
                if(n-i>=threshhode) {
                    max = threshhode;
                }
            }
        }
        return max;
    }
}
