package GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInUndirectedGraphBFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] arr = new boolean[V];
        boolean ans = false;
        for(int i = 0; i < V; i++) {
            if(!arr[i]) {
                if(BFS(arr, i, adj)) {
                    return true;
                }
            }
        }
        return false;

    }
    boolean BFS(boolean[] visited, int curElement, ArrayList<ArrayList<Integer>> adj) {
        visited[curElement] = true;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> cur;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int node;
        while(!q.isEmpty()) {
            node = q.poll();
            int i = 0;
            cur = adj.get(node);
            for(int next : cur){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    if(search(cur, next, i)) {
                        return true;
                    }
                    result.add(i, next);
                }
            }
        }
        return false;
    }
    boolean search(ArrayList<Integer> adj, int key, int range) {
        for(int i = 0; i <= range; i++) {
            if(adj.get(i) == key) {
                return true;
            }
        }
        return false;
    }



}
