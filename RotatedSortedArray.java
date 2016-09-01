/**
 * Created by yvan on 9/1/16.
 */
public class RotatedSortedArray {
    public static void main(String[] args){
        RotatedSortedArray rsa=new RotatedSortedArray();
        int[] nums=new int[]{4,5,6,7,8,9,1,2,3};
        rsa.search(nums,4);
    }
    public boolean search(int[] nums, int target) {
        int offset=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]) {
                offset = i + 1;
            }
        }
        int left=0;
        int right=nums.length-1;
        int mid=(int)((left+right)/2);
        int cmid=indexConvert(mid,offset,nums.length);
        while(left<=right){
//            System.out.println(nums[cmid]);
            if(nums[cmid]>target) {
                right = mid - 1;
            }else if (nums[cmid]<target){
                left = mid + 1;
            }else{
                return true;
            }
            mid=(int)((left+right)/2);
            cmid=indexConvert(mid,offset,nums.length);
        }
//        System.out.println("oops");
        return false;
    }
    public int indexConvert(int index,int offset,int n){
        int p=index+offset;
        if(p>=n){
            p=p%n;
        }
        return p;
    }
}
