import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by yvan on 9/14/16.
 */

public class RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> sequences=new HashSet<String>();
        int n=s.length();
        Set<String> duplicates=new HashSet<>();
        for(int i=0;i<=n-10;i++){
            String DNA=s.substring(i,i+10);
            if (!sequences.contains(DNA)){
                sequences.add(DNA);
            }else{
                if(!duplicates.contains(DNA))
                    duplicates.add(DNA);
            }
        }
        List<String> result=new LinkedList<>();
        result.addAll(duplicates);
        return result;
    }
}
