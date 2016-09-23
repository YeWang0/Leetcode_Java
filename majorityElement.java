import java.util.LinkedList;
import java.util.List;

/**
 * Created by yvan on 9/22/16.
 */
public class majorityElement {
    public static void main(String [] args){
        int[] nums={1,2,3,1,2,3,1,2,3,1,2,3,3,3,1};
        majorityElement me=new majorityElement();
        me.solution(nums);
    }
    public List<Integer> solution(int[] nums) {
        int cand1=0,cand2=0;
        int c1=0,c2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==cand1){
                c1++;
            }
            else if(nums[i]==cand2){
                c2++;
            }
            else if(c1==0){
                cand1=nums[i];
                c1++;
            }
            else if(c2==0){
                cand2=nums[i];
                c2++;
            }
            else{
                c1--;
                c2--;
            }

        }
        c1=0;
        c2=0;
        for( int i=0;i<nums.length;i++){
            if(nums[i]==cand1){
                c1++;
            }
            else if(nums[i]==cand2){
                c2++;
            }
        }
        LinkedList<Integer> result=new LinkedList<>();

        if(c1>nums.length/3){
            result.add(cand1);
        }
        if(c2>nums.length/3) {
            result.add(cand2);
        }
        return result;
    }
}
