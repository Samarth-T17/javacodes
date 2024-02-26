package DP.firstAtempt;

import java.util.ArrayList;

public class Seq1ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
    public static int climbStairs(int n) {
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(1);
        dp.add(1);
        return fun(n, dp);
    }
    static int fun(int n, ArrayList<Integer> dp) {
        if(n < 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return 1;
        }
        if(dp.size() > n) {
            return dp.get(n);
        }
        dp.add(fun(n - 1, dp) + fun(n - 2, dp));
        return dp.get(n);
    }
}
