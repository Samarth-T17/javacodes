package BINARYTREE;

import java.util.*;

public class AverageLevel2 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode cur;
        int sum;
        while(!q.isEmpty()){
            List<Integer> index = new ArrayList<>();
            int l = q.size();
            sum = 0;
            for(int i = 0; i < l; i++){
                cur = q.poll();
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                sum = sum + cur.val;
            }

            result.add((double)sum/l);
        }
        return result;

    }


}
