package GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedUnitWeightShortestDistance {
    public int[] shortestPath(int[][] edges,int N,int M ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int[] distance = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = (int)(1e9);
        }
        boolean[] visit = new boolean[N];
        visit[src] = true;
        distance[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        int curNode;
        while (!q.isEmpty()) {
            curNode = q.poll();
            for (int child : adj.get(curNode)) {
                if(distance[curNode] + 1 < distance[child]) {
                    distance[child] = distance[curNode] + 1;
                }
                if(!visit[child]){
                    q.offer(child);
                    visit[child] = true;
                }

            }
        }
        return distance;
    }
}
