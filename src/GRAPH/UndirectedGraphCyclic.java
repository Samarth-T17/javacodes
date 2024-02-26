package GRAPH;

import java.util.ArrayList;

public class UndirectedGraphCyclic {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visit = new boolean[V];
        boolean[] pathVisit = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visit[i]) {
                if(dfs(adj, i, visit, pathVisit)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visit, boolean[] pathVisit) {

        visit[node] = true;
        pathVisit[node] = true;
        ArrayList<Integer> cur = adj.get(node);
        for(int i = 0; i < cur.size(); i++) {
            if(!visit[cur.get(i)]) {
                if(dfs(adj, i, visit, pathVisit)) {
                    return true;
                }
                else if(pathVisit[node]) {
                    return true;
                }
            }
        }
        pathVisit[node] = false;
        return false;
    }
}
