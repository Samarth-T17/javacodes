package GRAPH;
//https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=distance-from-the-source-bellman-ford-algorithm
import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgo {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, (int)(1e8));
        distance[S] = 0;
        int parent;
        int child;
        int weight;
        for(int i = 0; i < V - 1; i++) {
            for(ArrayList<Integer> cur : edges) {
                parent = cur.get(0);
                child = cur.get(1);
                weight = cur.get(2);
                if(distance[parent] != (int)(1e8) && distance[parent] + weight < distance[child]) {
                    distance[child] = distance[parent] + weight;
                }
            }
        }
        for(ArrayList<Integer> cur : edges) {
            parent = cur.get(0);
            child = cur.get(1);
            weight = cur.get(2);
            if(distance[parent] != (int)(1e8) && distance[parent] + weight < distance[child]) {
                return new int[]{-1};
            }
        }
        return distance;

    }
}
