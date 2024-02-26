package DP.firstAtempt;

public class Seq11CherryPickup1 {
    public static void main(String[] args) {
        System.out.println(cherryPickup(new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}}));
    }
    public static int cherryPickup(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return helper(grid, 0, grid[0].length - 1, 0, dp);
    }
    static int helper(int[][] grid, int j1, int j2, int i, int[][] dp) {
        if(j1 >= grid[0].length || j2 >= grid[0].length || j1 < 0 || j2 < 0) {
            return Integer.MIN_VALUE;
        }
        int a = 0;
        if(dp[i][j1] != -1) {

        }

        if(i != grid.length - 1) {
            a = Math.max(a, helper(grid, j1 + 1, j2, i + 1, dp));
            a = Math.max(a, helper(grid, j1 + 1, j2 + 1, i + 1, dp));
            a = Math.max(a, helper(grid, j1 + 1, j2 - 1, i + 1, dp));
            a = Math.max(a, helper(grid, j1 - 1, j2, i + 1, dp));
            a = Math.max(a, helper(grid, j1 - 1, j2 + 1, i + 1, dp));
            a = Math.max(a, helper(grid, j1 - 1, j2 - 1, i + 1, dp));
            a = Math.max(a, helper(grid, j1, j2, i + 1, dp));
            a = Math.max(a, helper(grid, j1, j2 + 1, i + 1, dp));
            a = Math.max(a, helper(grid, j1, j2 - 1, i + 1, dp));
        }
        if(j1 == j2) {
            dp[i][j1] = a + grid[i][j1];
            return a + grid[i][j1];
        }
        else {
            dp[i][j1] = a + grid[i][j1];
            dp[i][j2] = a + grid[i][j2];
            return a + grid[i][j1] + grid[i][j2];
        }
    }
}
