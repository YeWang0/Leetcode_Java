import java.util.ArrayList;

/**
 * Created by yvan on 10/9/16.
 */
public class wordSearch {
    public boolean exist(char[][] board, String word) {
    if(board.length==0){
        return false;
    }
    boolean[][] visited=new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++)
        for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] == word.charAt(0)) {
                // System.out.println(i+" "+j);

                if (search(board, word, 0, visited, i, j)) {
                    return true;
                }
            }

        }
    return false;
}
    public boolean search(char[][] board, String word, int index, boolean[][] visited,int x,int y){
        if (index >= word.length()) {
            return true;
        }
        if(x>=0&&x<board.length&&y>=0&&y<board[0].length) {

            if (word.charAt(index) == board[x][y]) {

                if(!visited[x][y]) {
                    visited[x][y]=true;
                    if(search(board, word, index + 1, visited, x + 1, y))return true;
                    if(search(board, word, index + 1, visited, x - 1, y))return true;
                    if(search(board, word, index + 1, visited, x, y + 1))return true;
                    if(search(board, word, index + 1, visited, x, y - 1))return true;
                    visited[x][y]=false;
                }
            }
        }
        return false;
    }
}
