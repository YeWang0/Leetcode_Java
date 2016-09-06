import java.util.ArrayList;

/**
 * Created by yvan on 9/5/16.
 */
public class UglyNumbers {
    public static void main(String [] args){
        UglyNumbers un=new UglyNumbers();
        un.nthUgly(100);
    }
    public int nthUgly(int n){
        ArrayList<Integer> dp=new ArrayList<Integer>();
        dp.add(1);
        int x=0;
        int y=0;
        int z=0;
        int a,b,c;
        int min=1;
        for(int i=1;i<n;i++){
            a=dp.get(x)*2;
            b=dp.get(y)*3;
            c=dp.get(z)*5;
            min=min(a,b,c);
            dp.add(min);
            if(min==a){
                x++;
            }
            if(min==b){
                y++;
            }
            if(min==c){
                z++;
            }
        }
        System.out.println(min);
        return min;
    }
    public int min(int a,int b,int c){
        int min=c;
        if(a<min){
            min=a;
        }
        if(b<min){
            min=b;
        }
        return min;
    }
}
