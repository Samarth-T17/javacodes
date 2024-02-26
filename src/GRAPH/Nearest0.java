package GRAPH;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/01-matrix/description/
public class Nearest0 {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] result = new int[r][c];
        boolean[][] visit = new boolean[r][c];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(mat[i][j] == 0) {
                    q.offer(new Node(i, j, 0));
                    visit[i][j] = true;
                }
            }
        }
        Node cur;
        while (!q.isEmpty()) {
            cur = q.poll();
            cur.resultSet(result);
            cur.EnqueueNode(q, visit);
        }

        return result;
    }

}
class Node {
    int i;
    int j;
    int distance;
    Node(int i, int j, int distance) {
        this.i = i;
        this.j = j;
        this.distance = distance;
    }
    Node(Node old) {
        this.i = old.i;
        this.j = old.j;
        this.distance = old.distance + 1;
    }
    void EnqueueNode(Queue<Node> q, boolean[][] visit) {
        this.i = this.i + 1;
        if(this.nodeEval(visit)) {
            this.visitSet(visit);
            q.offer(new Node(this));
        }
        this.i = this.i - 2;
        if(this.nodeEval(visit)) {
            this.visitSet(visit);
            q.offer(new Node(this));
        }
        this.i = this.i + 1;
        this.j = this.j + 1;
        if(this.nodeEval(visit)) {
            this.visitSet(visit);
            q.offer(new Node(this));
        }
        this.j = this.j - 2;
        if(this.nodeEval(visit)) {
            this.visitSet(visit);
            q.offer(new Node(this));
        }
        this.j = this.j + 1;
    }
    boolean nodeEval(boolean[][] visit) {
        return this.i < visit.length && this.j < visit[0].length
                && this.i >= 0 && this.j >= 0 && !visit[this.i][this.j];
    }
    void resultSet(int[][] result) {
        result[this.i][this.j] = this.distance;
    }
    void visitSet(boolean[][] visit) {
        visit[this.i][this.j] = true;
    }
}