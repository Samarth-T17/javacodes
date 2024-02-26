package DP.firstAtempt;

import java.util.Arrays;

public class Seq14PartitionArrayIntoTwoArraysToMinimizeSumDifferenceGFG {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

    }
//    public static int minimumDifference(int[] arr) {
//        int N = arr.length;
//        int sum = 0;
//        for(int i : arr) {
//            sum += i;
//        }
//        helper(arr, (double) sum / 2, N, 0);
//        return 1;
//    }
//    static void helper(int[] arr, double sum, int i, int num) {
//        if(arr.length / 2 == num) {
//            System.out.println(sum);
//            return;
//        }
//        if(i == 0) {
//            return;
//        }
//        sum += arr[i - 1];
//        helper(arr, sum, i - 1, num + 1);
//        sum -= arr[i - 1];
//        helper(arr, sum, i - 1, num);
//    }
    public int minDifference(int arr[], int n)
    {
        int sum = 0;
        for(int i : arr) {
            sum += i;
        }
        int N = n;
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
        int ans = Integer.MAX_VALUE;
        int a = 0;
        for(int i = 0; i < prev.length; i++) {
            if(prev[i]) {
                a = Math.abs((sum - i) - i);
                if(a < ans) {
                    ans = a;
                }
            }
        }
        return ans;
    }
}
