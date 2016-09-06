import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by yvan on 9/5/16.
 */

public class ShuffleArray {
    int[] nums;
    Random r=new Random();
    public static void main(String [] args){
        ShuffleArray sa=new ShuffleArray(new int[]{1,2,3});
        for(int i:sa.shuffle()){
            System.out.println(i);
        }
    }
    public ShuffleArray(int[] nums) {
        this.nums=nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n=nums.length;
        int[] results=new int[nums.length];
        ArrayList<Integer> temp=new ArrayList<Integer>() ;
        for(int i:nums){
            temp.add(i);
        }
        int rand=0;
        for(int i=0;i<n;i++){
            rand=r.nextInt(n-i);
//            System.out.println("rand:"+rand);
//            System.out.println(temp.size());
            results[i]=temp.get(rand);
            temp.remove(rand);
        }
        return results;
    }
}
