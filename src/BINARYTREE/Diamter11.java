package BINARYTREE;

public class Diamter11 {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        diameterOfBinaryTree(root, max);
        return max[0];
    }
    public int diameterOfBinaryTree(TreeNode root, int[] max) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = diameterOfBinaryTree(root.left, max);
        int right = diameterOfBinaryTree(root.right, max);
        int maxi = left + right;
        if(maxi > max[0]){
            max[0] = maxi;
        }
        return Math.max(left, right) + 1;
    }
}
