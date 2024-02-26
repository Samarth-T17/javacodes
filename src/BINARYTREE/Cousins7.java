package BINARYTREE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cousins7 {
    public boolean isCousins(TreeNode root, int x, int y) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode cur;
        int xIndex = -1;
        int yIndex = -1;
        int flag = 0;
        while(true){
            List<Integer> index = new ArrayList<>();
            int l = q.size();

            for(int i = 0; i < l; i++){
                cur = q.poll();
                if(cur != null){
                    flag = 1;
                    q.offer(cur.left);
                    q.offer(cur.right);
                    if(cur.val == x){
                        xIndex = i;
                    }
                    if(cur.val == y){
                        yIndex = i;
                    }
                }
            }
            if(xIndex != -1 && yIndex != -1){
                if(xIndex/2 != yIndex/2){
                    return true;
                }
            }
            else{
                xIndex = -1;
                yIndex = -1;
            }
            if(flag == 0){
                return false;
            }
            flag = 0;
        }
    }
}
