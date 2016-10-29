/**
 * Created by yvan on 10/26/16.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean primes[]=new boolean[n+1];
        for(int i=0;i<=n;i++)
            primes[i]=true;
        int count=0;
        for(int i=2;i<n;i++){
            if(primes[i]){
                count++;
                for(int j=i;j<n;j+=i){
                    primes[j]=false;
                }
            }
        }
        return count;
    }
}
