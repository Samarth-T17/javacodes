package DP.firstAtempt;

import java.util.Arrays;

public class Seq8MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[m];
        int sum = 0;
        for(int i = m - 1; i >= 0; i--) {
            sum = sum + grid[i][n - 1];
            dp[i] = sum;
        }
        for(int j = n - 1; j > 0; j--) {
            for(int i = m - 1; i >= 0; i--) {
                if(i != m - 1) {
                    dp[i] = grid[i][j - 1] + Math.min(dp[i] , dp[i + 1]);
                }
                else {
                    dp[i] = grid[i][j - 1] + dp[i];
                }
            }
        }
        return dp[0];
    }
}
