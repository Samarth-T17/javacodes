package GRAPH;

import java.util.ArrayList;

public class NumberOfShortestPaths {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        ArrayList<Integer> t;
        int[] stops = new int[n];
        for (int[] road : roads) {
            t = new ArrayList<>(2);
            t.add(road[1]);
            t.add(road[2]);
            adj.get(road[0]).add(t);
        }
        return 0;
    }
}
