/**
 * Created by yvan on 8/30/16.
 */
public class SearchMatrix {
    public static void main(String [] args){
        SearchMatrix s=new SearchMatrix();
//        int[][] matrix={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] matrix={{-1}};
        System.out.println(s.search2DMatrix(matrix,-1));
    }
    public boolean search2DMatrix(int[][] matrix, int target) {
        if(matrix==null){
            return false;
        }
        int n=matrix.length;
        int l=matrix[0].length;
        for(int i=0;i<n;i++){
            System.out.println(matrix[i][0]);
            if(matrix[i][0]<=target && matrix[i][l-1]>=target) {
                if (matrix[i][0] == target || matrix[i][l - 1] == target) {
                    return true;
                } else {
                    if (binarySearch(matrix[i], target,l) == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean binarySearch(int[] list,int target,int length){
        if(length<3){
            return false;
        }
        int m=1;
        int n=length-2;
        int mid;
        while(m<=n){
            mid=(int)((m+n)/2);
            if(list[mid]==target){
                return true;
            }
            else if(list[mid]<target){
                m=mid+1;
            }
            else if(list[mid]>target){
                n=mid-1;
            }
        }
        return false;
    }
}
