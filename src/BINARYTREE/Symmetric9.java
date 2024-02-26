package BINARYTREE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Symmetric9 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root.left);
        q2.offer(root.right);
        TreeNode cur1, cur2;
        int flag = 0;
        while(!q1.isEmpty() && !q2.isEmpty()){
            int l = q1.size();
            for(int i = 0; i < l; i++){
                cur1 = q1.poll();
                cur2 = q2.poll();
                if(cur1 != null && cur2 == null || cur2 != null && cur1 == null){
                    return false;
                }
                if(cur1 != null && cur2 != null){
                    if(cur1.val != cur2.val){
                        return false;
                    }
                    flag = 1;
                    q1.offer(cur1.right);
                    q1.offer(cur1.left);
                    q2.offer(cur2.left);
                    q2.offer(cur2.right);
                }

            }
            if(flag == 0){
                break;
            }
            flag = 1;
        }
        return true;

    }

}
