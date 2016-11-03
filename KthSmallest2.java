import java.util.PriorityQueue;

/**
 * Created by yvan on 11/3/16.
 */
public class KthSmallest2 {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        PriorityQueue<Tuple> pq=new PriorityQueue<>();
        Tuple t=new Tuple();
        for(int i=0;i<n;i++)pq.offer(new Tuple(i,0,matrix[i][0]));
        for(int j=0;j<k;j++){
            t=pq.poll();
            if(t.y==m-1){
                continue;
            }
            pq.offer(new Tuple(t.x,t.y+1,matrix[t.x][t.y+1]));

        }
        return t.val;
    }
    class Tuple implements Comparable<Tuple>{
        int x,y,val;
        public Tuple(){}
        public Tuple(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
        @Override
        public int compareTo(Tuple o) {
            return this.val-o.val;
        }
    }
}
