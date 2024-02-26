package GRAPH;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visit = new boolean[V];
        visit[0] = true;
        dfs(adj, result, 0, visit);
        return result;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result, int node, boolean[] visit) {
        visit[node] = true;
        result.add(node);
        for(int cur : adj.get(node)) {
            if(!visit[cur]) {
                dfs(adj, result, cur, visit);
            }
        }
    }
}
