package GRAPH;
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
public class CycleInUndirectedGraphDFS {
//    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//        boolean[] arr = new boolean[V];
//        boolean ans = false;
//        for(int i = 0; i < V; i++) {
//            if(!arr[i]) {
//                if(bfs(arr, adj, i)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    boolean dfs(boolean[] visit, ArrayList<ArrayList<Integer>> adj, int node) {
//        boolean nice = false;
//        visit[node] = true;
//        for(int cur : adj.get(node)) {
//            if(cur != parent ){
//                if(!visit[cur]){
//                    if(dfs(visit, adj, cur, node)) {
//                        return true;
//                    }
//                }
//                else {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
