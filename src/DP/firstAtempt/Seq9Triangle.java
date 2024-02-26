package DP.firstAtempt;

import java.util.*;

public class Seq9Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int l = triangle.size();
        List<Integer> dp = new ArrayList<>(triangle.get(l - 1));
        for(int i = l - 2; i >= 0; i++) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp.set(j, triangle.get(i).get(j) + Math.max(dp.get(j), dp.get(i + 1)));
            }
            dp.remove(dp.size() - 1);
        }
        return dp.get(0);
    }
    /* Brute force recursion sol
    public int minimumTotal(List<List<Integer>> triangle) {
        return helper(triangle, 0, 0);
    }
    int helper(List<List<Integer>> triangle, int index, int level) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(level + 1 < triangle.size()) {
            left = helper(triangle, index, level + 1);
            if(index + 1 < triangle.get(level + 1).size()) {
                right = helper(triangle, index + 1, level + 1);
            }
        }
        else {
            return triangle.get(level).get(index);
        }
        return triangle.get(level).get(index) + Math.min(left, right);
    }
     */
}
