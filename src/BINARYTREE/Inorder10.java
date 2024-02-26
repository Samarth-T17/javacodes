package BINARYTREE;

import java.util.ArrayList;
import java.util.List;

public class Inorder10 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }
    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if(root == null){
            return;
        }
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}
