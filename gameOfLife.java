/**
 * Created by yvan on 8/31/16.
 */
public class gameOfLife {
    private int[][] board;
    private int m;
    private int n;
    public static void main(String [] args){
        int[][] board={{0,1,1},{0,0,1},{0,0,1}};
        gameOfLife g=new gameOfLife(board);
//        System.out.println(g.check(0,1));
        for(int i=0;i<g.m;i++)
            for(int j=0;j<g.n;j++){
                g.board[i][j]=g.check(i,j);
            }
        for(int i=0;i<g.m;i++)
            for(int j=0;j<g.n;j++){
                g.board[i][j]>>=1;
            }
        
    }
    public gameOfLife(int[][] board){
        this.board=board.clone();
        this.m=board.length;
        if(this.m>0){
            this.n=board[0].length;
        }
        else{
            this.n=0;
        }
    }
    public int check(int x,int y){
        int count;
        int state=board[x][y] & 1;
        if(state==1){
            count=-1;
            for(int i=Math.max(x-1,0);i<Math.min(x+2,m);i++)
                for(int j=Math.max(y-1,0);j<Math.min(y+2,n);j++){
                    count+=board[i][j]&1;
            }
            if(count==2||count==3){
                return 3;
            }
            else{
                return 1;
            }
        }else{
            count=0;
            for(int i=Math.max(x-1,0);i<Math.min(x+2,m);i++)
                for(int j=Math.max(y-1,0);j<Math.min(y+2,n);j++){
                    count+=board[i][j]&1;
            }
            if(count==3){
                return 2;
            }else{
                return 0;
            }
        }
    }
}
