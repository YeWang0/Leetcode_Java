/**
 * Created by yvan on 10/12/16.
 */
import java.util.ArrayList;
import java.util.List;
public class sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        int left,mid,right;
        ArrayList<List<Integer>> result=new ArrayList<>();
        ArrayList<Integer> temp;
        for(int i=0;nums[i]<=0;i++){
            left=nums[i];
            for(int j=i+1;j<nums.length-1;j++){
                mid=nums[j];
                int target=-left-mid;
                for(int k=nums.length-1;k>j;k--){
                    right=nums[k];
                    if(right==target){
                        temp=new ArrayList<>();
                        temp.add(left);
                        temp.add(mid);
                        temp.add(right);
                        result.add(temp);
                    }else if(right<target){
                        break;
                    }
                }
            }
        }
        return result;
    }
}
