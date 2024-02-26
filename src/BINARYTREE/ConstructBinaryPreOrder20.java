package BINARYTREE;
import java.util.Stack;
public class ConstructBinaryPreOrder20 {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = {0};
        return lmao(preorder,index, 1000000);
    }
    public TreeNode lmao(int[] preorder, int[] index, int max){
        if(index[0]==preorder.length||preorder[index[0]]>=max){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;
        root.left=lmao(preorder, index,root.val);
        root.right=lmao(preorder,index,max);
        return root;


    }
}
