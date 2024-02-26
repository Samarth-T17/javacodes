package BINARYTREE;

import java.util.List;
import java.util.ArrayList;


public class PathSumAllCombination23 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        hasPathSum(root, targetSum, 0, result, cur);
        return result;
    }
    public void hasPathSum(TreeNode root, int targetSum, int branchSum, List<List<Integer>> result, List<Integer> cur) {
        if (root == null) {
            return;
        }
        branchSum = branchSum + root.val;
        cur.add(root.val);
        if (branchSum == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(cur));
            return;
        }
        hasPathSum(root.left, targetSum, branchSum, result, cur);
        hasPathSum(root.right, targetSum, branchSum, result, cur);
        cur.remove(cur.size() - 1);
    }
}
