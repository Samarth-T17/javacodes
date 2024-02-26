package BINARYTREE;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode cur;
        while(!q.isEmpty()){
            List<Integer> index = new ArrayList<>();
            int l = q.size();
            for(int i = 0; i < l; i++){
                cur = q.poll();
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                index.add(cur.val);
            }

            result.add(index);
        }
        return result;
    }
}
