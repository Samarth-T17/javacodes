package GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/topological-sort/1
public class TopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visit = new boolean[V];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < V; i++) {
            if(!visit[i]) {
                dfs(adj, s, visit, i);
            }
        }
        int[] result = new int[s.size()];
        for(int i = 0; i < s.size(); i++) {
            result[i] = s.pop();
        }
        return result;
    }
     static void dfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> s, boolean[] visit, int node) {
         visit[node] = true;
         for(int cur : adj.get(node)) {
            if(!visit[node]) {
                dfs(adj, s, visit, cur);
            }
         }
        s.push(node);
     }
}
