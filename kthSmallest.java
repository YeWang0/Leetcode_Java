import java.util.PriorityQueue;
import java.util.Iterator;
/**
 * Created by yvan on 8/29/16.
 */

public class kthSmallest {
    int [][] matrix;
    int k;
    kthSmallest(int[][] matrix, int k){
        this.matrix=matrix;
        this.k=k;
    }
    public void print(PriorityQueue<Tuple> pq){
        Iterator it = pq.iterator();

        System.out.println ( "Priority queue values are: ");

        while (it.hasNext()){
            System.out.println ( "Value: "+ ((Tuple)it.next()).getVal());
        }
    }
    public int compare(){
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int i =0;i<n;i++)
            pq.offer(new Tuple(0,i,matrix[0][i]));
        for(int j=0;j<k-1;j++){
            Tuple t=pq.poll();
            if(t.x<n-1){
                pq.offer(new Tuple(t.x+1,t.y,matrix[t.x+1][t.y]));
            }
        print(pq);
        }

        return pq.poll().getVal();
    }

    public static void main(String [] args){
        int [][] Matrix={{2,5,9},{6,11,13},{12,13,15}};
        kthSmallest kt=new kthSmallest(Matrix,3);
        System.out.print(kt.compare());
    }
}
class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}
//int [][] Matrix={{1,2,3},{2,3,4},{3,4,5}};

