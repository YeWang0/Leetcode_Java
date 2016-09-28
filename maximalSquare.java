/**
 * Created by yvan on 9/28/16.
 */
public class maximalSquare {
    public int maxSquare(char[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        if(m==0){
            return 0;
        }
        if(n==0){
            return 0;
        }
        int result=0;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if (result==0 && matrix[i][j]=='1'){
                    result=1;
                }
            dp[i][j]=matrix[i][j]-'0';
            }

        int max=0;
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1'){
                    max=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                    if(max>0){
                        dp[i][j]=max+1;
                        if(max+1>result){
                            result=max+1;
                        }
                    }
                }
            }
        for(int i=1;i<m;i++) {
            for (int j = 1; j < n; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return result;
    }
}
