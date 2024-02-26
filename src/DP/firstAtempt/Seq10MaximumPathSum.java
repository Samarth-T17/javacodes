package DP.firstAtempt;

public class Seq10MaximumPathSum {
    static int maximumPath(int n, int grid[][]) {
        int[] dpCur = new int[n];
        int[] dpPrev = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            dpCur[i] = grid[n - 1][i];
            dpPrev[i] = dpCur[i];
        }
        int a, b;
        for(int i = n - 2; i >= 0; i++) {
            for(int j = 0; j < n; j++) {
                if(j == 0) {
                    a = Integer.MAX_VALUE;
                }
                else {
                    a = dpPrev[j - 1];
                }
                if(j == n - 1) {
                    b = Integer.MAX_VALUE;
                }
                else {
                    b = dpPrev[j + 1];
                }
                dpCur[j] = grid[i][j] + Math.max(a, Math.max(b, dpPrev[j]));
            }
            for(int k = 0; k < n; k++) {
                dpPrev[k] = dpCur[k];
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(max < dpCur[i]) {
                max = dpCur[i];
            }
        }
        return max;
    }
}
