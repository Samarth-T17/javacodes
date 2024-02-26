package GRAPH;
import java.util.*;
// https://practice.geeksforgeeks.org/problems/eventual-safe-states/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=eventual-safe-states
public class EventualSafeStateBSF {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<List<Integer>> adjReversed = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adjReversed.add(new ArrayList<>());
        }
        int[] inDegree = new int[V];
        for(int i = 0; i < V; i++) {
            for(int j : adj.get(i)) {
                adjReversed.get(j).add(i);
                inDegree[i] ++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[V];
        for(int i = 0; i < V; i++ ) {
            if(inDegree[i] == 0) {
                q.offer(i);
                check[i] = true;
            }
        }
        int cur;
        while (!q.isEmpty()) {
            cur = q.poll();
            for (int j : adjReversed.get(cur)) {
                inDegree[j] --;
                if(inDegree[j] == 0) {
                    q.offer(j);
                    check[j] = true;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            if(check[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
