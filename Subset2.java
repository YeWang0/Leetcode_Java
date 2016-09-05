import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yvan on 9/5/16.
 */
public class Subset2 {
    public static void main(String [] args){
        Subset2 ss=new Subset2();
        ArrayList<Integer> set= new ArrayList<Integer>(Arrays.asList(1,2,3,3,3,4,4,4));

        ArrayList<ArrayList<Integer>> results=new ArrayList<ArrayList<Integer>>();
        results.add(new ArrayList<Integer>());

//        recursion
        ss.subset_recursion(results,0,set,0);

        for(ArrayList<Integer> a:results){
            for (Integer i:a) {
                System.out.print(i);
            }
            System.out.println();
        }

        results=new ArrayList<ArrayList<Integer>>();
        results.add(new ArrayList<Integer>());
        //        iteration
        ss.subset_iteration(results,0,set);

        for(ArrayList<Integer> a:results){
            for (Integer i:a) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public void subset_recursion(ArrayList<ArrayList<Integer>> results,int index,ArrayList<Integer> set,int end){

        int n=results.size()-1;
        if(index>=set.size()){
            return ;
        }
        if(index>0 && set.get(index)==set.get(index-1)){
            if(end==0){
                end=(int)n/2;
            }
        }
        else {
            end=0;
        }

        int i=0;
        while(n>=0){
            if(end!=0){
                if(i>end){

                    break;
                }else {
                    i++;
                }
            }
            ArrayList<Integer> res=new ArrayList<Integer>();
            res.add(set.get(index));
            ArrayList<Integer> result=results.get(n);
            res.addAll(result);
            results.add(res);
            n--;
        }
        subset_recursion(results,index+1,set,end);
    }

    public void subset_iteration(ArrayList<ArrayList<Integer>> results,int index,ArrayList<Integer> set){
        int end=0;
        while(true) {
            int n = results.size() - 1;
            if (index >= set.size()) {
                return;
            }
            if(index>0 && set.get(index)==set.get(index-1)){
                if(end==0){
                    end=(int)n/2;
                }
            }
            else {
                end=0;
            }

            int i=0;
            while (n >= 0 ) {

                if(end!=0){
                    if(i>end){

                        break;
                    }else {
                        i++;
                    }
                }
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

