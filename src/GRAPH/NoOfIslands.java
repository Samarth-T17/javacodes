package GRAPH;
// https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find_the_number_of_islands
public class NoOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visit[i][j]) {
                    traversal(i, j, grid, visit);
                    count++;
                }
            }
        }
        return count;
    }
    void traversal(int i, int j, char[][] grid, boolean[][] visit) {
        if((i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)) {
            return;
        }
        if(grid[i][j] == '0' || visit[i][j]) {
            return;
        }

        visit[i][j] = true;
        traversal(i , j + 1, grid, visit);
        traversal(i  , j - 1, grid, visit);
        traversal(i + 1, j, grid, visit);
        traversal(i + 1, j + 1, grid, visit);
        traversal(i + 1, j - 1, grid, visit);
        traversal(i - 1, j + 1, grid, visit);
        traversal(i - 1, j, grid, visit);
        traversal(i - 1, j - 1, grid, visit);

    }
}
/*
LEETCODE - https://leetcode.com/problems/number-of-islands/
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visit[i][j]) {
                    traversal(i, j, grid, visit);
                    count++;
                }
            }
        }
        return count;
    }
    void traversal(int i, int j, char[][] grid, boolean[][] visit) {
        if((i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)) {
            return;
        }
        if(grid[i][j] == '0' || visit[i][j]) {
            return;
        }

        visit[i][j] = true;
        traversal(i , j + 1, grid, visit);
        traversal(i  , j - 1, grid, visit);
        traversal(i + 1, j, grid, visit);

        traversal(i - 1, j, grid, visit);


    }
}
 */