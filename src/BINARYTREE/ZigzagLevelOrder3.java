package BINARYTREE;

import java.util.*;

public class ZigzagLevelOrder3 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        TreeNode cur;
        boolean flag = true;
        while(!q.isEmpty()){
            List<Integer> index = new ArrayList<>();
            int l = q.size();
            for(int i = 0; i < l; i++){
                if(flag) {
                    cur = q.removeFirst();
                    if(cur.left != null){
                        q.addLast(cur.left);
                    }
                    if(cur.right != null){
                        q.addLast(cur.right);
                    }
                    index.add(cur.val);
                }
                else {
                    cur = q.removeLast();
                    if(cur.right != null){
                        q.addFirst(cur.right);
                    }
                    if(cur.left != null){
                        q.addFirst(cur.left);
                    }

                    index.add(cur.val);
                }
            }
            flag = !flag;
            result.add(index);
        }
        return result;
    }
}
