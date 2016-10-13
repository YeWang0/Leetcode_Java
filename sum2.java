import java.util.HashMap;

/**
 * Created by yvan on 10/12/16.
 */
public class sum2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> set = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(set.containsKey(target-nums[i])){
                return new int[]{i,set.get(target-nums[i])};
            }else{
                set.put(nums[i],i);
            }
        }
    return new int[]{-1,-1};
    }
}
