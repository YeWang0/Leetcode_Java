import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yvan on 9/5/16.
 */
public class Subset {
    public static void main(String [] args){
        ArrayList<Integer> set= new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        ArrayList<ArrayList<Integer>> results=new ArrayList<ArrayList<Integer>>();
        results.add(new ArrayList<Integer>());
        Subset ss=new Subset();
//        recursion
//        ss.subset_recursion(results,0,set);

//        iteration
        ss.subset_iteration(results,0,set);
        
        for(ArrayList<Integer> a:results){
            for (Integer i:a) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public void subset_recursion(ArrayList<ArrayList<Integer>> results,int index,ArrayList<Integer> set){

        int n=results.size()-1;
        if(index>=set.size()){
            return ;
        }
        while(n>=0){
            ArrayList<Integer> res=new ArrayList<Integer>();
            res.add(set.get(index));
            ArrayList<Integer> result=results.get(n);
            res.addAll(result);
            results.add(res);
            n--;
        }
        subset_recursion(results,index+1,set);
    }

    public void subset_iteration(ArrayList<ArrayList<Integer>> results,int index,ArrayList<Integer> set){
        while(true) {
            int n = results.size() - 1;
            if (index >= set.size()) {
                return;
            }
            while (n >= 0) {
                ArrayList<Integer> res = new ArrayList<Integer>();
                res.add(set.get(index));
                ArrayList<Integer> result = results.get(n);
                res.addAll(result);
                results.add(res);
                n--;
            }
            index++;
        }
    }
}
