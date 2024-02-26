package DP.firstAtempt;

public class Seq3HouseRobber1 {
    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        int temp;
        for (int num : nums) {
            temp = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
