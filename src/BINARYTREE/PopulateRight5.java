package BINARYTREE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class PopulateRight5 {
    public Node connect(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node cur;
        while(!q.isEmpty()) {
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
                if(!q.isEmpty()) {
                    cur.next = q.peek();
                }
                else {
                    cur.next = null;
                }
            }
        }
        return root;
    }
}
