package BINARYTREE;

import java.util.ArrayList;

public class KSmall17 {
    public int kthSmallest(TreeNode root, int k) {
        int[] sol = new int[1];
        int[] i = new int[1];
        kthSmallest(root, k, sol, i);
        return sol[0];
    }
    public void kthSmallest(TreeNode root, int k, int[] sol, int[] i){
        if(root == null) {
            return;
        }
        kthSmallest(root.left, k, sol, i);
        i[0]++;
        if(k == i[0]) {
            sol[0] = root.val;
            i[0]++;
        }
        if(k < i[0]) {
            return;
        }
        kthSmallest(root.right, k, sol, i);

    }

}
