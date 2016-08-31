/**
 * Created by yvan on 8/31/16.
 */
public class PeakElement {
    public static void main(String [] args){
        PeakElement pe=new PeakElement();
        pe.findPeakElement(new int[]{1,3,2,4,6,5,1});
    }

    public int findPeakElement(int[] nums){
        int max=nums[0];
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
//        System.out.println(index);
        return index;
    }
}
