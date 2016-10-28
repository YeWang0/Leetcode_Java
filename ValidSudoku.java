import java.util.HashSet;

/**
 * Created by yvan on 10/26/16.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        HashSet<Character> set;
        for(int i=0;i<n;i++){
            set=new HashSet<>();
            for(int j=0;j<n;j++) {
                if (board[i][j]!='.'){
                    if(set.contains(board[i][j])){
                        return false;
                    }else{
                        set.add(board[i][j]);
                    }
                }
            }
        }
        for(int j=0;j<n;j++){
            set=new HashSet<>();
            for(int i=0;i<n;i++) {
                if (board[i][j]!='.'){
                    if(set.contains(board[i][j])){
                        return false;
                    }else{
                        set.add(board[i][j]);
                    }
                }
            }
        }
        for(int i=0;i<n;i+=3){
            for(int j=0;j<n;j+=3) {
                set=new HashSet<>();
                for(int m=0;m<3;m++)
                    for(int t=0;t<3;t++) {
                        if (board[i+m][j+t] != '.') {
                            if (set.contains(board[i+m][j+t])) {
                                return false;
                            } else {
                                set.add(board[i+m][j+t]);
                            }
                        }
                    }
            }
        }
        return true;
    }
}
