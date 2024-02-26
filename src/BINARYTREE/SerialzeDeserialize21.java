package BINARYTREE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerialzeDeserialize21 {
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        return serialize(root, builder).toString();
    }
    public StringBuilder serialize(TreeNode root, StringBuilder builder) {
        if(root == null){
            return builder;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode cur;
        while(!q.isEmpty()){
            int l = q.size();
            for(int i = 0; i < l; i++){
                cur = q.poll();
                if(cur != null) {
                    q.offer(cur.left);
                    q.offer(cur.right);
                    builder.append(cur.val);
                }
                else {
                    builder.append('N');
                }
                builder.append(',');
            }
        }
        return builder;
    }
    public TreeNode deserialize(String data) {
        Queue<TreeNode> q = new LinkedList<>();
        int[] endIndex = {0};
        TreeNode root = getNode(data, endIndex);
        q.offer(root);
        TreeNode cur;
        while(!q.isEmpty()) {
            int l = q.size();
            for(int i = 0; i < l; i++) {
                cur = q.poll();
                cur.left = getNode(data, endIndex);
                cur.right = getNode(data, endIndex);
                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
        return root;
    }
    public TreeNode getNode(String data, int[] endIndex){
        int num = 0;
        if(data.charAt(endIndex[0]) == 'N') {
            endIndex[0] = endIndex[0] + 2;
            return null;
        }
        boolean isNegative = false;
        if(data.charAt(endIndex[0]) == '-') {
            isNegative = true;
            endIndex[0]++;
        }
        int i = 0;
        for(i = endIndex[0]; data.charAt(i) != ','; i++) {
            num = num * 10 + data.charAt(i) - 48;
        }
        endIndex[0] = i + 1;
        if(isNegative) {
            num = num * -1;
        }
        return new TreeNode(num);
    }
}
