/**
 * Created by yvan on 10/21/16.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int a,b,c,d;
        int exp;
        Arrays.sort(nums);
        ArrayList<List<Integer>> result=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            while(i>0&&i<nums.length-3&&nums[i]==nums[i-1])i++;
            if(i>=nums.length-3)break;
            a=nums[i];
            temp.add(a);
            for(int j=i+1;j<nums.length-2;j++){
                while(j>i+1&&j<nums.length-2&&nums[j]==nums[j-1])j++;
                if(j>=nums.length-2)break;
                b=nums[j];
                temp.add(b);
                exp=target-a-b;

                int m=j+1;
                int n=nums.length-1;
                while(n>m){
                    while(m>j+1&&m<n&&nums[m]==nums[m-1])m++;
                    while(n<nums.length-1&&n>m&&nums[n]==nums[n+1])n--;
                    if(m>=n)break;
                    if(nums[m]+nums[n]>exp) {
                        n--;
                    }else if(nums[m]+nums[n]<exp){
                        m++;
                    }else{

                        temp.add(nums[m]);
                        temp.add(nums[n]);
                        result.add(new ArrayList<Integer>(temp));
                        temp.remove(temp.size()-1);
                        temp.remove(temp.size()-1);
                        m++;
                    }
                }
                temp.remove(temp.size()-1);
            }
            temp.remove(temp.size()-1);
        }
        return result;
    }

}
