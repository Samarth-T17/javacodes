package BINARYTREE;

public class FlattenTree13 {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        flatten(root.left);
        TreeNode cur = root;
        TreeNode right = root.right;
        root.right = root.left;
        while(cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
        flatten(cur.right);
    }
}
