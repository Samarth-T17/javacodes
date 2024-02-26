package BINARYTREE;

import java.util.ArrayList;
import java.util.List;

public class PathSumTotal24 {
    public int sumNumbers(TreeNode root) {
        int[] totalSum = {0};
        hasPathSum(root, 0, totalSum);
        return totalSum[0];
    }
    public void hasPathSum(TreeNode root, int branchSum, int[] totalSum) {
        if (root == null) {
            return;
        }
        branchSum = branchSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            totalSum[0] = totalSum[0] + branchSum;
            return;
        }
        hasPathSum(root.left, branchSum, totalSum);
        hasPathSum(root.right, branchSum, totalSum);

    }
}
