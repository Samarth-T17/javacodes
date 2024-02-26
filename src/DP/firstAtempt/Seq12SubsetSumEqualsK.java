package DP.firstAtempt;

import java.util.Arrays;
import java.util.HashMap;
import java.io.*;
import java.util.*;
public class Seq12SubsetSumEqualsK {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Seq12SubsetSumEqualsK ob = new Seq12SubsetSumEqualsK();
            if (ob.isSubsetSum(N, arr, sum))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
    static Boolean isSubsetSum(int N, int[] arr, int sum) {
        boolean[] prev = new boolean[sum + 1];
        boolean[] cur = new boolean[sum + 1];
        boolean[] temp;
        Arrays.fill(prev, false);
        prev[0] = true;
        cur[0] = true;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] > j) {
                    cur[j] = prev[j];
                } else {
                    cur[j] = prev[j] || prev[j - arr[i - 1]];
                }
            }
            prev[0] = true;
            temp = prev;
            prev = cur;
            cur = temp;
        }
        return prev[sum];
    }
    /*
    Tabulation solution
    static Boolean isSubsetSum(int N, int[] arr, int sum){
        int[][] dp = new int[N + 1][sum + 1];
        for(int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0; i < N + 1; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i < sum + 1; i++) {
            dp[0][i] = 0;
        }
        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j] == 1 || dp[i - 1][j - arr[i - 1]] == 1 ? 1 : 0;
                }
            }
        }
        return dp[N][sum] == 1 ? true : false;
    }
     */
    /*
    Memoization solution
    static int helper(int[] arr, int i, int sum, int[][] dp) {
        if(i == 0) {
            if(sum == 0) return 1;
            return 0;
        }
        if(sum == 0) {
            return 1;
        }
        if(dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int take = 0, notTake = 0;
        if(arr[i - 1] > sum) {
            return dp[i][sum] = helper(arr, i - 1, sum, dp);
        }
        take = helper(arr, i - 1, sum - arr[i - 1], dp);
        notTake = helper(arr, i - 1, sum, dp);
        return dp[i][sum] = take == 1 || notTake == 1 ? 1 : 0;
    }
     */
    /*
    Recursive solution
    static boolean helper(int[] arr, int i, int sum) {
        if(i == 0) {
            return sum == arr[0];
        }
        if(sum == 0) {
            return true;
        }
        boolean take = false, notTake = false;
        if(arr[i - 1] > sum) {
            return helper(arr, i - 1, sum);
        }
        take = helper(arr, i - 1, sum - arr[i - 1]);
        notTake = helper(arr, i - 1, sum);
        return take || notTake;
    }
     */
}