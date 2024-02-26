package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implementing-dijkstra-set-1-adjacency-matrix
public class DijikstarPq {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(Comparator.comparingInt(x -> x.distance));
        int[] distance = new int[V];
        Arrays.fill(distance, (int)(1e9));
        pq.offer(new Pair(S, 0));
        Pair cur;
        while (!pq.isEmpty()) {
            cur = pq.poll();
            for(int i = 0; i < adj.get(cur.node).size(); i++) {
                if(distance[cur.node] + adj.get(cur.node).get(i).get(1) < distance[adj.get(cur.node).get(i).get(0)]) {
                    distance[adj.get(cur.node).get(i).get(0)] = distance[cur.node] + adj.get(cur.node).get(i).get(1);
                }
                pq.offer(new Pair(adj.get(cur.node).get(i).get(0), distance[adj.get(cur.node).get(i).get(0)]));
            }
        }
        return distance;
    }
}
class Pair{
    int node;
    int distance;
    public Pair(int distance,int node){
        this.node = node;
        this.distance = distance;
    }
}