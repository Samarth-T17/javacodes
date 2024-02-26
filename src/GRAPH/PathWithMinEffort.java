package GRAPH;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/path-with-minimum-effort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=path-with-minimum-effort
public class PathWithMinEffort {
    int MinimumEffort(int[][] heights) {
        int v = heights.length;
        int h = heights[0].length;
        PriorityQueue<Height> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.effort));
        int[][] distance = new int[v][h];
        pq.offer(new Height(0,0, heights[0][0]));
        for (int i = 0; i < v; i++) {
            Arrays.fill(distance[i], (int)(1e9));
        }
        distance[0][0] = 0;
        Height cur;
        int curI;
        int curJ;
        int curEffort;
        while (!pq.isEmpty()) {
            cur = pq.poll();
            curI = cur.i;
            curJ = cur.j;
            curEffort = cur.effort;
            if(curI == v - 1 && curJ == h - 1) {
                return curEffort;
            }
            int newI = curI - 1;
            int newJ = curJ;
            if(newI >= 0) {
                if(Math.max(Math.abs(heights[curI][curJ] - heights[newI][newJ]), curEffort) < distance[newI][newJ]) {
                    distance[newI][newJ] = Math.max(Math.abs(heights[curI][curJ] - heights[newI][newJ]), curEffort);
                    pq.offer(new Height(newI, newJ, Math.max(Math.abs(heights[curI][curJ] - heights[newI][newJ]), curEffort)));
                }
            }
            newI = curI;
            newJ = newJ - 1;
            if(newJ >= 0) {
                if(Math.max(Math.abs(heights[curI][curJ] - heights[newI][newJ]), curEffort) < distance[newI][newJ]) {
                    distance[newI][newJ] = Math.max(Math.abs(heights[curI][curJ] - heights[newI][newJ]), curEffort);
                    pq.offer(new Height(newI, newJ, Math.max(Math.abs(heights[curI][curJ] - heights[newI][newJ]), curEffort)));
                }
            }
            newJ = curJ;
            newI = curI + 1;
            if(newI < v) {
                if(Math.max(Math.abs(heights[curI][curJ] - heights[newI][newJ]), curEffort) < distance[newI][newJ]) {
                    distance[newI][newJ] = Math.max(Math.abs(heights[curI][curJ] - heights[newI][newJ]), curEffort);
                    pq.offer(new Height(newI, newJ, Math.max(Math.abs(heights[curI][curJ] - heights[newI][newJ]), curEffort)));
                }
            }
            newI = curI;
            newJ = curJ + 1;
            if(newJ < h) {
                if(Math.max(Math.abs(heights[curI][curJ] - heights[newI][newJ]), curEffort) < distance[newI][newJ]) {
                    distance[newI][newJ] = Math.max(Math.abs(heights[curI][curJ] - heights[newI][newJ]), curEffort);
                    pq.offer(new Height(newI, newJ, Math.max(Math.abs(heights[curI][curJ] - heights[newI][newJ]), curEffort)));
                }
            }
        }
        return -1;

    }
}
class Height{
    int i;
    int j;
    int effort;
    Height(int i, int j, int effort) {
        this.i = i;
        this.j = j;
        this.effort = effort;
    }
}
