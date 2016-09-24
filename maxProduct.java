/**
 * Created by yvan on 9/12/16.
 */
public class maxProduct {
//dp
    public int GetMaxProduct(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        int pos[]=new int[n];
        int neg[]=new int[n];
        int result=nums[0];
        pos[0]=nums[0];
        neg[0]=nums[0];
        for(int i=1;i<n;i++){
            pos[i]=Math.max(Math.max(pos[i-1]*nums[i],neg[i-1]*nums[i]),nums[i]);
            neg[i]=Math.min(Math.min(pos[i-1]*nums[i],neg[i-1]*nums[i]),nums[i]);
            result=Math.max(pos[i],result);
        }
        return result;
    }
}
