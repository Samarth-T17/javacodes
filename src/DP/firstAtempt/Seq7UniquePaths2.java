package DP.firstAtempt;

import java.util.Arrays;

public class Seq7UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        if(obstacleGrid.length == 1) {
            return 1;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[1].length;
        int[] dp = new int[m];
        int t = 1;
        for(int i = m - 1; i >= 0; i--) {
            if(obstacleGrid[i][n - 1] == 1) {
                t = 0;
            }
            dp[i] = t;
        }
        for(int j = n - 1; j > 0; j--) {
            for(int i = m - 1; i >= 0; i--) {
                if(obstacleGrid[i][j - 1] == 1) {
                    dp[i] = 0;
                }
                else if(i != m - 1) {
                    dp[i] = dp[i] + dp[i + 1];
                }
            }
        }
        return dp[0];
    }
}
