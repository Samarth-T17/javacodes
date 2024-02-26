package BINARYTREE;

public class PathSum22 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }
    public boolean hasPathSum(TreeNode root, int targetSum, int branchSum) {
        if(root == null) {
            return false;
        }
        branchSum = branchSum + root.val;
        if(branchSum == targetSum) {
            if(root.left == null && root.right == null) {
                return true;
            }
            return hasPathSum(root.right, targetSum, branchSum) || hasPathSum(root.left, targetSum, branchSum);
        }
        return hasPathSum(root.right, targetSum, branchSum) || hasPathSum(root.left, targetSum, branchSum);
    }
}
