import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by yvan on 10/19/16.
 */

public class CombinationSum2 {
    public List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combination(candidates,target,0,new ArrayList<Integer>());
        return result;
    }
    public void combination(int[] candidates,int target, int index,List<Integer> pre){
        if(target<0){
            return;
        }
        if (target==0) {
            result.add(new ArrayList<>(pre));
            return;
        }
        for(int i=index;i<candidates.length;i++) {
            if(i>index&&candidates[i]==candidates[i-1])continue;
            pre.add(candidates[i]);
            combination(candidates, target - candidates[i], i + 1, pre);
            pre.remove(pre.size() - 1);
        }
    }
}
