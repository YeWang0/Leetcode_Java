/**
 * Created by yvan on 9/22/16.
 */
public class minSubArrayLen {
    public int solution(int s, int[] nums){
        int sum=0;
        int i=0;
        int j=0;
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        if(n==0){
            return 0;
        }
        while(j<n){
            sum+=nums[j++];
            while(sum>s){
                min=Math.max(min,j-i);
                sum-=nums[i++];
            }
        }
        return min==Integer.MIN_VALUE?0:min;
    }
}
