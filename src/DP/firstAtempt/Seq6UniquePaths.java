package DP.firstAtempt;

import java.util.ArrayList;
import java.util.Arrays;

public class Seq6UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for(int j = n - 1; j > 0; j--) {
            for(int i = m - 1; i >= 0; i--) {
                if(i != m - 1) {
                    dp[i] = dp[i] + dp[i + 1];
                }
            }
        }
        return dp[0];
    }
}
    /* Memoization solution
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] a : dp) {
            Arrays.fill(a, -1);
        }
        dp[m - 1][n - 1] = 0;
        return helper(0, 0, m, n, dp);
    }
    int helper(int i, int j, int m, int n, int dp[][]) {
        if(!(i < m && j < n && i >= 0 && j >= 0)) {
            return 0;
        }
        if(i == m - 1 && j == n - 1) {
            return 1;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = helper(i + 1, j, m, n, dp) + helper(i, j + 1, m, n, dp);
        return dp[i][j];
    }
     */

