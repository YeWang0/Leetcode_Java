import java.util.ArrayList;

/**
 * Created by yvan on 8/31/16.
 */
public class numSquares {
    public static void main(String [] a){
        numSquares ns=new numSquares();
        ns.DPsquares(10093);
    }
    public int DPsquares(int n){
//        ArrayList<Integer> result=new ArrayList<Integer>();
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            dp[i]=i;
        }
        for(int i=2;;i++){
            if(i*i<=n){
                dp[i*i]=1;
            }else{
                break;
            }
        }

        int temp;
        for(int i=2;i<=n;i++){
//            get dp[i]
            for(int j=i-1;j>0&&2*j>=i;j--){
                if(dp[j]+dp[i-j]<dp[i]){
                    dp[i]=dp[j]+dp[i-j];
                }
            }
        }
        for(int i:dp){
            System.out.println(i);
        }
        return dp[n];
    }
}
