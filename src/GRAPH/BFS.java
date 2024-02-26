package GRAPH;
import java.util.*;
public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        visited[0] = true;
        ArrayList<Integer> result = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int node;
        while(!q.isEmpty()) {
            node = q.poll();
            result.add(node);
            for(int next : adj.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return result;
    }
}
