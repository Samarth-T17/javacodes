package GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/topological-sort/1
public class TopologicalSortBFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[V];
        for(ArrayList<Integer> cur : adj) {
            for(int now : cur) {
                inDegree[now]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int[] result = new int[V];
        int i = 0;
        int cur;
        while (!q.isEmpty()) {
            cur = q.poll();
            result[i] = cur;
            i++;
            for(int child : adj.get(cur)) {
                inDegree[child]--;
                if(inDegree[child] == 0) {
                    q.offer(child);
                }
            }
        }
        return result;
    }

}
