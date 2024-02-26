package BINARYTREE;

public class IsBst15 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, root);
    }
    public boolean isValidBST(TreeNode root, TreeNode cmp){
        if(root == null) {
            return true;
        }
        if(root.left != null){
            if(root.val <= root.left.val || cmp.val <= root.left.val) {
                return false;
            }
        }
        if(root.right != null){
            if(root.right.val <= root.val || root.right.val <= cmp.val) {
                return false;
            }
        }
        return isValidBST(root.right, root) && isValidBST(root.left, root);
    }
}
