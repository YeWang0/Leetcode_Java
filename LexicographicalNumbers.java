import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by yvan on 9/6/16.
 */
public class LexicographicalNumbers {
    public boolean smaller(Integer a,Integer b){
        String sa=a.toString();
        String sb=b.toString();
        for(int i=0;i<Math.min(sa.length(),sb.length());i++){
            if(sa.charAt(i)==sb.charAt(i)){
                continue;
            }else if(sa.charAt(i)>sb.charAt(i)){
                return false;
            }else{
                return true;
            }
        }
        return sa.length()<sb.length();
    }
    public int nextInt(int a,int range){
        if(a*10<=range){
            return a*10;
        }else if((a+1)%10!=0){
            return a+1;
        }else{
            int b=a+1;
            while (b%10==0){
                b=(int)(b/10);
            }
            return b;
        }
    }
    public List<Integer> lexicalOrder(int n){
        List<Integer> result=new ArrayList<Integer>();
        int[] state=new int[n+1];
        for(int i=0;i<n+1;i++){
            state[i]=0;
        }
        state[1]=1;
        state[0]=-1;
        result.add(1);
        int next=1;
        int temp;
        while(true){
            temp=nextInt(next,n);
            if(temp>n){
                for(int i=(int)(temp/10);i<n+1;i++){
                    if(state[i]==0){
                        temp=i;
                        break;
                    }
                }
                if(temp>n)break;
            }
//            System.out.println("-"+temp);
            if(state[temp]==1){
                break;
            }
            next=temp;
            result.add(next);

            state[next]=1;
        }

        for (Integer i: result) {
            System.out.println(i);
        }
        return  result;
    }
    public static void main(String [] args){
        LexicographicalNumbers lgn=new LexicographicalNumbers();
        lgn.lexicalOrder(100);
    }
}
