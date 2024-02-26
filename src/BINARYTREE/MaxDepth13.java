package BINARYTREE;

public class MaxDepth13 {
    public int maxDepth(TreeNode root) {
        return maxDepthI(root);
    }
    public int maxDepthI(TreeNode root){
        if(root == null) {
            return 0;
        }
        if(root.left == root.right) {
            return 1;
        }
        int left = maxDepthI(root.left);
        int right = maxDepthI(root.right);
        return Math.max(left, right) + 1;
    }
}
