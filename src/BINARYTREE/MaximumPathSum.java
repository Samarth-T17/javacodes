package BINARYTREE;

public class MaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MAX_VALUE};
        maxPathSum(root, max);
        return max[0];
    }
    public int maxPathSum(TreeNode root, int[] max) {
        if(root == null) {
            return 0;
        }
        int cur =  root.val;
        int left = maxPathSum(root.left, max);
        int right = maxPathSum(root.right, max);
        cur = Math.max(cur, Math.max(cur + left, Math.max(cur + right, cur + left + right)));
        if(max[0] < cur) {
            max[0]  = cur;
        }
        return cur;
    }
}
