package BINARYTREE;

public class ConstructBinary19 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] index={0};
        return lmao(preorder,inorder,index,0,preorder.length-1);
    }
    public TreeNode lmao(int[] preorder,int[] inorder, int[] index, int s, int l) {
        if(index[0]==preorder.length){
            return null;
        }
        int rootIndex= search(inorder, s, l, preorder[index[0]]);
        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;
        if(s == l){
            return root;
        }
        root.left= lmao(preorder,inorder,index,s,rootIndex-1);
        root.right= lmao(preorder,inorder,index,rootIndex+1,l);
        return root;
    }
    public int search(int[] array,int s, int l, int key){
        for(int i=s; i< l;i++){
            if(array[i]==key){
                return i;
            }
        }
        return -1;
    }

}