package GRAPH;

import java.util.ArrayList;
import java.util.HashSet;

// https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1
public class DistinctIslands {
    int countDistinctIslands(int[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        HashSet<String> total = new HashSet<>();
        Direction start = new Direction(0, 0);
        StringBuilder lmao;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visit[i][j] && grid[i][j] == 1) {
                    lmao = new StringBuilder();
                    dfs(i, j, grid, visit, lmao, new Direction(0, 0));
                    total.add(lmao.toString());
                }
            }
        }

        return total.size();
    }
    void dfs(int i, int j, int[][] board, boolean[][] visit, StringBuilder now, Direction cur) {
        if(!(i < board.length && j < board[0].length && i >= 0 && j >= 0 && board[i][j] == 1 &&!visit[i][j])) {
            delete(now);
            return;
        }

        visit[i][j] = true;
        now.append(',');
        now.append(cur.i + 1);
        now.append(',');
        now.append(cur.j);
        dfs(i + 1, j, board, visit, now, new Direction(cur.i + 1, cur.j));
        now.append(',');
        now.append(cur.i);
        now.append(',');
        now.append(cur.j - 1);
        dfs(i, j - 1, board, visit, now, new Direction(cur.i, cur.j - 1));
        now.append(',');
        now.append(cur.i);
        now.append(',');
        now.append(cur.j + 1);
        dfs(i, j + 1, board, visit, now, new Direction(cur.i, cur.j + 1));
        now.append(',');
        now.append(cur.i - 1);
        now.append(',');
        now.append(cur.j);
        dfs(i - 1, j, board, visit, now, new Direction(cur.i - 1, cur.j));
    }
    void delete(StringBuilder a) {
        int c = 0;
        while(c != 2) {
            if(',' == a.charAt(a.length() - 1)) {
                c++;
            }
            a.deleteCharAt(a.length() - 1);
        }
    }
}
class Direction{
    int i;
    int j;
    Direction(int i, int j) {
        this.i = i;
        this.j = j;
    }
}