package BINARYTREE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RigthView6 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode cur;
        while(!q.isEmpty()){
            int l = q.size();
            for(int i = 0; i < l; i++){
                cur = q.poll();
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                if(i == l-1) {
                    result.add(cur.val);
                }
            }
        }
        return result;
    }
}
