import java.util.Map;

/**
 * Created by yvan on 8/30/16.
 */
public class LongestIncreasingSubsequence {
    public static void main(String [] args){
        LongestIncreasingSubsequence l1=new LongestIncreasingSubsequence();
        l1.lengthOfLIS(new int[]{1,2,3,4,5});
    }
    public int lengthOfLIS(int[] nums) {
        int [] lengths=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            lengths[i]=1;
        }
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    lengths[i]= Math.max(lengths[i],lengths[j]+1);
                }
            }
        }
        int max=1;
        for(int l:lengths){
            if(l>max){
                max=l;
            }
        }
        System.out.println(max);
        return max;
    }
}
