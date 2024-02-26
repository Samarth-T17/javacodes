package DP.firstAtempt;

public class Seq4HouseRobber2 {
    public int rob(int[] nums) {
        return Math.max(helper(0, nums.length - 1, nums), helper(1, nums.length, nums));
    }
    int helper(int i, int j , int[] nums) {
        int rob1 = 0, rob2 = 0, temp;
        for(int m = i; m < j; m++) {
            temp = Math.max(rob1 + nums[m], rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
