package DP.firstAtempt;

import java.util.Arrays;

public class Seq15CountSubsetsWithSumK {
    static int MOD = 1000000007;
    public static int findWays(int arr[], int tar) {
        int ans = 0;
        int sum = tar;
        int N = arr.length;
        int[] prev = new int[sum + 1];
        int[] cur = new int[sum + 1];
        int[] temp;
        prev[0] = 1;
        cur[0] = 1;
        int firstNum = 0;
        if(arr[0] == 0)
            cur[0] = 2;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if(arr[i - 1] == 0) {
                    cur[j] = (2 * prev[j]) % MOD;
                }
                else if (arr[i - 1] > j) {
                    cur[j] = prev[j] % MOD;
                }
                else {
                    cur[j] = (prev[j] + prev[j - arr[i - 1]]) % MOD;
                }
            }
            firstNum = prev[0];
            temp = prev;
            prev = cur;
            cur = temp;
            if(arr[i - 1] == 0) {
                cur[0] = (2 * firstNum) % MOD;
            }
            else{
                cur[0] = firstNum;
            }
        }
        return (prev[sum]);
    }
    static int helper(int[] arr, int i, int tar) {
        if(tar == 0) {
            return 1;
        }
        if(i == 0) {
            return 0;
        }
        if(arr[i - 1] > tar) {
            return helper(arr, i - 1, tar);
        }
        return helper(arr, i - 1, tar) % MOD + helper(arr, i - 1, tar - arr[i - 1]) % MOD;
    }
}
