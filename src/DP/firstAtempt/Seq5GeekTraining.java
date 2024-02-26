package DP.firstAtempt;

import java.util.ArrayList;
import java.util.Arrays;

public class Seq5GeekTraining {
    public int maximumPoints(int[][] points,int N){
        int[][] dp = new int[N][4];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 4; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][1], points[0][0]);
        dp[0][3] = Math.max(points[0][1], Math.max(points[0][2], points[0][0]));
        int max = 0;
        for(int i = 1; i < N; i++) {
            max = 0;
            for(int j = 0; j < 3; j++) {
                dp[i][j] = points[i][j] + dp[i - 1][j];
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    /* Memoization solution
    public int maximumPoints(int[][] points,int N){
        int[][] dp = new int[N][3];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                dp[i][j] = -1;
            }
        }
        return findAllSequences(points, 0, -1, dp);
    }
    int findAllSequences(int[][] points, int i, int j, int[][] dp) {
        int max = 0;
        if(i == points.length - 1) {
            for(int k = 0; k < 3; k++) {
                if(k != j) {
                    max = Math.max(max, points[i][k]);
                }
            }
            if(j >= 0) {
                dp[i][j] = max;
            }
            return max;
        }
        else if(j >= 0 && dp[i][j] != -1) {
            return dp[i][j];
        }
        else {
            for(int k = 0; k < 3; k++) {
                if(k != j) {
                    max = Math.max(findAllSequences(points, i + 1, k, dp) + points[i][k], max);
                }
            }
        }
        if(j >= 0) {
            dp[i][j] = max;
        }
        return max;
    }
    /*

    /*
    recursion brute force
    static int max;
    public int maximumPoints(int points[][],int N){
        max = 0;
        return findAllSequences(points, 0, 0, -1);

    }
    int findAllSequences(int points[][], int sum, int i, int j) {
        int max = 0;
        if(i == points.length - 1) {
            for(int k = 0; k < 3; k++) {
                if(k != j) {
                    max = Math.max(max, points[i][k]);
                }
            }
            return max;
        }
        for(int k = 0; k < 3; k++) {
            if(k != j) {
                max = Math.max(findAllSequences(points, sum + points[i][k], i + 1, k) + points[i][k], max);
            }
        }
        return max;
    }*/
}
