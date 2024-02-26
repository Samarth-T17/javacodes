package GRAPH;

import java.util.Queue;

// https://leetcode.com/problems/surrounded-regions/description/
public class XO {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        boolean[][] visit = new boolean[r][c];
        char[][] ans = new char[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                ans[i][j] = board[i][j];
            }
        }
        for(int i = 0; i < r; i++) {
            if(board[i][0] == 'O' && !visit[i][0]) {
                dfs(i, 0, board, visit, false, ans);
            }
            if(board[i][r - 1] == 'O' && !visit[i][r - 1]) {
                dfs(i, r - 1, board, visit, false, ans);
            }
        }
        for(int i = 0; i < c; i++) {
            if(board[0][i] == 'O' && !visit[i][0]) {
                dfs(0, i, board, visit, false, ans);
            }
            if(board[c - 1][i] == 'O' && !visit[i][r - 1]) {
                dfs(c - 1, i, board, visit, false, ans);
            }
        }
        for(int i = 1; i < r - 1; i++) {
            for(int j = 1; j < c - 1; j++) {
                if(board[i][j] == 'O' && !visit[i][j]) {
                    dfs(i, j, board, visit, true, ans);
                }
            }
        }
        board = ans;
    }
    void dfs(int i, int j, char[][] board, boolean[][] visit, boolean isGroup, char[][] ans) {
        if(!(i < board.length && j < board[0].length && i >= 0 && j >= 0 && board[i][j] == 'O' &&!visit[i][j])) {
            return;
        }
        visit[i][j] = true;
        if(!isGroup) {
            ans[i][j] = 'X';
        }
        dfs(i + 1, j, board, visit, isGroup, ans);
        dfs(i, j - 1, board, visit, isGroup, ans);
        dfs(i, j + 1, board, visit, isGroup, ans);
        dfs(i - 1, j, board, visit, isGroup, ans);
    }
}
