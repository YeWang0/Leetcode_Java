import java.util.HashSet;

/**
 * Created by yvan on 11/3/16.
 */
public class PerfectSquare {
    public boolean isPerfectSquare(int num) {
        long i;
        for(i=2;i<num;i*=2){
            if(i*i>num)break;
        }
        long left=i/2;
        long right=i;
        long mid=0;
        while(left<=right){
            mid=(left+right)/2;
            long t=mid*mid;
            if(t<num){
                left=mid+1;
            }else if(t>num){
                right=mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
//    public boolean isPerfectSquare2(int num) {
//        HashSet<Integer> set=new HashSet<>();
//        for(int i=2;i<num;){
//            if(num%i==0){
//                num=num/i;
//                if(set.contains(i)){
//                    set.remove(i);
//                }else{
//                    if(set.isEmpty())set.add(i);
//                    else return false;
//                }
//            }else{
//                i++;
//            }
//        }
//        return set.isEmpty();
//    }
}
