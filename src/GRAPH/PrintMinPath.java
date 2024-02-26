package GRAPH;

import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-weighted-undirected-graph
public class PrintMinPath {
    public static List<Integer> shortestPath(int V, int m, int[][] edges){
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        ArrayList<Integer> pairs;
        for(int[] e : edges) {
            pairs = new ArrayList<>(2);
            pairs.add(e[1]);
            pairs.add(e[2]);
            adj.get(e[0]).add(pairs);
            pairs = new ArrayList<>(2);
            pairs.add(e[0]);
            pairs.add(e[2]);
            adj.get(e[1]).add(pairs);
        }
        PriorityQueue<Pair100> pq = new PriorityQueue<>(Comparator.comparingInt((Pair100 x) -> x.distance).thenComparingInt(x -> x.node));
        int[] distance = new int[V + 1];
        pq.offer(new Pair100(1, 0));
        Pair100 cur;
        int[] parent = new int[V + 1];
        for(int i = 0; i < V + 1; i++) {
            parent[i] = i;
            distance[i] = (int)(1e9);
        }
        distance[1] = 0;
        while (!pq.isEmpty()) {
            cur = pq.poll();
            for(int i = 0; i < adj.get(cur.node).size(); i++) {
                if(distance[cur.node] + adj.get(cur.node).get(i).get(1) < distance[adj.get(cur.node).get(i).get(0)]) {
                    distance[adj.get(cur.node).get(i).get(0)] = distance[cur.node] + adj.get(cur.node).get(i).get(1);
                    parent[adj.get(cur.node).get(i).get(0)] = cur.node;
                    pq.offer(new Pair100(adj.get(cur.node).get(i).get(0), distance[adj.get(cur.node).get(i).get(0)]));
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        if(parent[V] == V) {
            result.add(-1);
            return result;
        }
        while (parent[V] != V) {
            result.add(V);
            V = parent[V];
        }
        result.add(1);
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int V = 5, E = 6;

        int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};

        List < Integer > path = shortestPath(V, E, edges);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

}
class Pair100 {
    int node;
    int distance;
    public Pair100(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}