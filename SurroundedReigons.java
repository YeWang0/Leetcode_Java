import java.util.ArrayList;
import java.awt.Point;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yvan on 9/20/16.
 */
public class SurroundedReigons {
    public static void main(String [] args){
        char[][]board={
                {'O','X','X','X','X','X'},
                {'X','X','O','O','X','O'},
                {'O','O','X','O','O','X'},
                {'X','O','X','X','X','O'},
                {'X','X','O','X','O','X'},
                {'X','O','X','X','O','O'}};
        SurroundedReigons sr=new SurroundedReigons();
        sr.solve(board);
    }
    public void solve(char[][] board){
        int m=board.length;
        if(m<3){
            return;
        }
        int n=board[0].length;
        if(n<3){
            return;
        }
        HashSet<Point> save=new HashSet<>();
        for(int i=0;i<m;i++) {
            if (board[i][0]=='O'){
                save.add(new Point(i,0));
            }
            if (board[i][n-1]=='O'){
                save.add(new Point(i,n-1));
            }
        }

        for(int i=1;i<n-1;i++) {
            if (board[0][i]=='O'){
                save.add(new Point(0,i));
            }
            if (board[m-1][i]=='O'){
                save.add(new Point(m-1,i));
            }
        }

        boolean flag=true;
        HashSet<Point> temp;
        while(flag){
//            for (Point p:save){
//                System.out.println(p.x+" "+p.y);
//            }
//            System.out.println("---");
            temp=new HashSet<>();
            flag=false;
            for (Point p:save){
                for(Point adj:getAdjacent(p,m,n)){
                    if(board[adj.x][adj.y]=='O' && !save.contains(adj) && !temp.contains(adj)){
                        temp.add(adj);
                        flag=true;
                    }
                }
            }
            for(Point tp:temp){
                save.add(tp);
            }
        }
        System.out.println(save.contains(new Point(0,0)));
//        for (Point p:save){
//            System.out.println(p.x+" "+p.y);
//        }
        for(int i=0;i<m;i++)
            for (int j=0;j<n;j++){
                if(board[i][j]=='O' && !save.contains(new Point(i,j))){
                    board[i][j]='X';
                }
            }

        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }

    }
    public ArrayList<Point> getAdjacent(Point point,int m,int n){
        ArrayList<Point> adjacent=new ArrayList<>();
        if(point.x-1>=0){
            adjacent.add(new Point(point.x-1,point.y));
        }
        if(point.x+1<m){
            adjacent.add(new Point(point.x+1,point.y));
        }
        if(point.y-1>=0){
            adjacent.add(new Point(point.x,point.y-1));
        }
        if(point.y+1<n){
            adjacent.add(new Point(point.x,point.y+1));
        }
//        System.out.println("+++");
//        for (Point p:adjacent){
//            System.out.println(p.x+" "+p.y);
//        }
//        System.out.println("+++");
        return adjacent;
    }
}
