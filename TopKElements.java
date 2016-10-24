/**
 * Created by yvan on 10/24/16.
 */
import java.util.*;

public class TopKElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){

            queue.add(entry.getKey());
        }
        for(int i=0;i<k;i++){
            result.add(queue.poll());
        }
        return result;
    }
}
