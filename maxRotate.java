/**
 * Created by yvan on 9/22/16.
 */
public class maxRotate {
//    public int maxRotateFunction(int[] A) {
//        int max=Integer.MIN_VALUE;
//        int temp=0;
//        int index=0;
//        int n=A.length;
//        for(int t=0;t<A.length;t++) {
//            index = t;
//            for (int i = 0; i < n; i++) {
//                temp += A[index] * A[i];
//                index++;
//                if(index>=n){
//                    index%=n;
//                }
//            }
//            if(temp>max){
//                max=temp;
//            }
//        }
//        return max;
//
//    }
    public int maxRotateFunction(int[] A) {
        int max=0;
        int temp=0;
        int n=A.length;
        int sum=0;
        int result;
        for(int i=0;i<n;i++){
            max+=i*A[i];
            sum+=A[i];
        }
        result=max;
        for(int j=1;j<n;j++){
            temp=max+sum-n*A[n-j];
            // System.out.println(temp);
            if(temp>result){
                result=temp;
            }
            max=temp;
        }
        return result;
    }
}
