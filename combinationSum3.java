/**
 * Created by yvan on 10/2/16.
 */
import java.util.ArrayList;
import java.util.List;
public class combinationSum3 {
    public static void main(String [] args){
        combinationSum3 cs=new combinationSum3();
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        result=cs.combinationSum3(1,2,1);
        for(int i=0;i<result.size();i++) {
            temp = result.get(i);
            for (int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(j)+" ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int goal,int start) {
//        System.out.println(k+" "+goal+" "+start);
        List<List<Integer>> result=new ArrayList<>();
        List<List<Integer>> sub=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        if(k==1 &&goal<10 &&goal>=start){
            temp.add(goal);
            result.add(temp);
            return result;
        }else if(start>9||k==1||goal<start){
            return result;
        }else{
            for(int i=start;i<10;i++){
                if(goal-i>=i+1) {
                    sub = combinationSum3(k - 1, goal - i, i + 1);
                    if (sub.size() > 0) {
                        for (int j = 0; j < sub.size(); j++) {
                            temp = sub.get(j);
                            temp.add(0,i);
                            result.add(temp);
                        }
                    }
                }
            }
            return result;
        }

    }
}
