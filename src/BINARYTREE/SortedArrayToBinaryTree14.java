package BINARYTREE;

public class SortedArrayToBinaryTree14 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        int l = nums.length - 1;
        int mid = l / 2;
        root = insert(root, nums[mid]);
        giveElement(root, 0, mid - 1, nums);
        giveElement(root, mid + 1, l, nums);
        return root;
    }
    public void giveElement(TreeNode root, int start, int last, int[] nums) {
        if(start <= last){
            int mid = ( start + last ) / 2;
            insert(root, nums[mid]);
            giveElement(root, mid + 1, last, nums);
            giveElement(root, start, mid - 1, nums);
        }
    }
    public TreeNode insert(TreeNode root, int n){
        if(root == null){
            root = new TreeNode(n);
            return root;
        }
        if(n < root.val) {
            root.left = insert(root.left, n);
        }
        else {
            root.right = insert(root.right, n);
        }
        return root;
    }
}
