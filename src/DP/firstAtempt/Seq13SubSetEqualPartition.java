package DP.firstAtempt;

import java.util.Arrays;

public class Seq13SubSetEqualPartition {
    public boolean canPartition(int[] arr) {
        int sum = 0;
        for(int i : arr) {
            sum += i;
        }
        if(sum % 2 == 1) {
            return false;
        }
        int N = arr.length;
        sum /= 2;
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
}
