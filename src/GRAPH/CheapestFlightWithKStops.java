package GRAPH;

import java.util.ArrayList;
import java.util.*;

public class CheapestFlightWithKStops {
    public static void main(String[] args) {
        int n = 5, src = 0, dst = 4, K = 2;
        int[][] flights={{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}, {3, 4, 1}};

        CheapestFlightWithKStops obj = new CheapestFlightWithKStops();
        int ans = obj.CheapestFLight(n,flights,src,dst,K);

        System.out.print(ans);
        System.out.println();
    }
    public int CheapestFLight(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        ArrayList<Integer> t;
        int[] stops = new int[n];
        for (int[] flight : flights) {
            t = new ArrayList<>(2);
            t.add(flight[1]);
            t.add(flight[2]);
            adj.get(flight[0]).add(t);
        }
        Queue<Pair4> pq = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance, (int)(1e9));
        distance[src] = 0;
        pq.offer(new Pair4(src, 0, 0));
        Pair4 cur;
        stops[src] = 0;
         int curK;
        while (!pq.isEmpty()) {
            cur = pq.poll();
            curK = cur.nStops;
            if((curK == k + 1)) {
                continue;
            }
            for(int i = 0; i < adj.get(cur.node).size(); i++) {
                if(distance[cur.node] + adj.get(cur.node).get(i).get(1) < distance[adj.get(cur.node).get(i).get(0)] && curK <= k) {
                    distance[adj.get(cur.node).get(i).get(0)] = distance[cur.node] + adj.get(cur.node).get(i).get(1);
                    pq.offer(new Pair4(adj.get(cur.node).get(i).get(0), distance[adj.get(cur.node).get(i).get(0)], curK + 1));
                    stops[adj.get(cur.node).get(i).get(0)] = curK + 1;
                }
                else if (stops[adj.get(cur.node).get(i).get(0)] > curK + 1) {
                    pq.offer(new Pair4(adj.get(cur.node).get(i).get(0), distance[adj.get(cur.node).get(i).get(0)], curK + 1));
                    stops[adj.get(cur.node).get(i).get(0)] = curK + 1;
                }

            }
        }
        if(distance[dst] == (int)(1e9)) {
            return -1;
        }
        return distance[dst];
    }
}
class Pair4 {
    int node;
    int distance;
    int nStops;
    public Pair4(int node, int distance, int nStops){
        this.node = node;
        this.distance = distance;
        this.nStops = nStops;
    }
}