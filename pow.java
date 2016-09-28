import java.util.ArrayList;

/**
 * Created by yvan on 9/27/16.
 */
public class pow {
    public double recursion_pow(double x,int n){
        if(x==0){
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if(n%2==0){
            return recursion_pow(x*x,n/2);
        }else{
            return recursion_pow(x*x,n/2)*x;
        }
    }
    public double get_pow(double x, int n){
        boolean flag=false;
        if(n<0){
            n=-n;
            flag=true;
        }
        if(n==0){
            return 1;
        }

        ArrayList<Double>dp=new ArrayList<Double>();
        dp.add(x);
        int index=1;
        double result;
        int i=0;
        while (index*2<=n){
            dp.add(dp.get(i)*dp.get(i));
            i+=1;
            index=index*2;
        }
        result=dp.get(i);
        n-=index;
        while(n>0){
            index=index/2;
            i-=1;
            if(index<=n){
                result*=dp.get(i);
                n-=index;
            }
        }

        if(flag){
            result=1/result;
        }
        return result;
    }
}
