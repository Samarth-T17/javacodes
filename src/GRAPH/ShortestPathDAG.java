package GRAPH;

import java.util.ArrayList;
import java.util.Stack;
// https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=direct-acyclic-graph
public class ShortestPathDAG {
    static void dfs(ArrayList<ArrayList<ArrayList<Integer>>> adj, Stack<Integer> s, boolean[] visit, int node) {
        visit[node] = true;
        for(ArrayList<Integer> cur : adj.get(node)) {
            if(!visit[cur.get(0)]) {
                dfs(adj, s, visit, cur.get(0));
            }
        }
        s.push(node);
    }
    public int[] shortestPath(int N,int M, int[][] edges) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        ArrayList<Integer> cur;
        for (int[] edge : edges) {
            cur = new ArrayList<>(2);
            cur.add(edge[1]);
            cur.add(edge[2]);
            adj.get(edge[0]).add(cur);
        }
        int[] distance = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = (int)(1e9);
        }
        distance[0] = 0;
        boolean[] visit = new boolean[N];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < N; i++) {
            if(!visit[i]) {
                dfs(adj, s, visit, i);
            }
        }
        int a;
        while (!s.isEmpty()) {
            a = s.pop();
            for (int i = 0; i < adj.get(a).size(); i++) {
                int v = adj.get(a).get(i).get(0);
                int wt = adj.get(a).get(i).get(1);
                if (distance[a] + wt < distance[v]) {
                    distance[v] = wt + distance[a];
                }
            }
        }
        for(int i = 0; i < N; i++) {
            if(distance[i] == (int)(1e9)) {
                distance[i] = -1;
            }
        }
        return distance;
    }
}
