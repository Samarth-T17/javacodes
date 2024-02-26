package DP.secondAttempt;


import java.util.Arrays;
import java.util.*;
import java.io.*;
import java.lang.*;
public class Seq1Knapsack01 {
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //reading total testcases
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());

            int val[] = new int[n];
            int wt[] = new int[n];

            String st[] = read.readLine().trim().split("\\s+");

            //inserting the values
            for(int i = 0; i < n; i++)
                val[i] = Integer.parseInt(st[i]);

            String s[] = read.readLine().trim().split("\\s+");

            //inserting the weigths
            for(int i = 0; i < n; i++)
                wt[i] = Integer.parseInt(s[i]);

            //calling method knapSack() of class Knapsack
            System.out.println(new Seq1Knapsack01().knapSack(w, wt, val, n));
        }
    }
    static int knapSack(int W, int[] wt, int[] val, int n)
    {
        int[] prev = new int[W + 1];
        int[] cur = new int[W + 1];
        int[] temp;
        Arrays.fill(prev, 0);
        cur[0] = 0;
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < W + 1; j++) {
                if(wt[i - 1] > j) {
                    cur[j] = prev[j];
                }
                else{
                    cur[j] = Integer.max(prev[j] , val[i - 1] + prev[j - wt[i - 1]]);
                }
            }
            prev[0] = 0;
            temp = prev;
            prev = cur;
            cur = temp;
        }
        return prev[W];
    }
    /*
    recursive solution
    static int helper(int w, int wt[], int val[], int i) {
        if(i == 0 || w == 0) {
            return 0;
        }
        if(wt[i - 1] > w) {
            return helper(w, wt, val, i - 1);
        }
        return  Integer.max(helper(w, wt, val, i - 1), val[i - 1] +  helper(w - wt[i - 1], wt, val, i - 1));
    }
     */
    /*
    memoization solution
    static int helper(int w, int wt[], int val[], int i, int[][] dp) {
        if(i == 0 || w == 0) {
            return 0;
        }
        if(dp[i][w] != -1) {
            return dp[i][w];
        }
        if(wt[i - 1] > w) {
            return dp[i][w] = helper(w, wt, val, i - 1, dp);
        }
        return dp[i][w] = Integer.max(helper(w, wt, val, i - 1, dp), val[i - 1] +  helper(w - wt[i - 1], wt, val, i - 1, dp));
    }
     */
    /*
    Tabulation
    static int knapSack(int W, int[] wt, int[] val, int n)
    {
        int[][] dp = new int[wt.length + 1][W + 1];
        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for(int i = 0; i < W + 1; i++) {
            dp[0][i] = 0;
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < W + 1; j++) {
                if(wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = Integer.max(dp[i - 1][j] , val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
            }
        }
        return dp[n][W];
    }
     */
}
