package GRAPH;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
// https://leetcode.com/problems/rotting-oranges/description/

public class RottenOrange {
    public int orangesRotting(int[][] grid) {
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        int count = 0;
        int fresh = 0;
        int lmao = 0;
        ArrayList<Integer> coordinates;
        ArrayList<Integer> curCoordinates;
        int flag = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    coordinates = new ArrayList<Integer>(2);
                    coordinates.add(i);
                    coordinates.add(j);
                    q.offer(coordinates);
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if(fresh == 0) {
            return 0;
        }
        if(q.isEmpty()) {
            if(fresh == 0) {
                return -1;
            }
        }

        int i, j;
        while(!q.isEmpty() && fresh > 0) {
            fresh = fresh - lmao;
            lmao = 0;
            int l = q.size();
            for(int k = 0; k < l; k++) {
                curCoordinates = q.poll();
                i = curCoordinates.get(0);
                j = curCoordinates.get(1);

                if(isSafe(i + 1, j, grid)) {
                    coordinates = new ArrayList<Integer>(2);
                    coordinates.add(i + 1);
                    coordinates.add(j);
                    q.offer(coordinates);
                    grid[i + 1][j] = 2;
                    lmao++;
                }
                if(isSafe(i - 1, j, grid)) {
                    coordinates = new ArrayList<Integer>(2);
                    coordinates.add(i - 1);
                    coordinates.add(j);
                    q.offer(coordinates);
                    grid[i - 1][j] = 2;
                    lmao++;
                }
                if(isSafe(i, j + 1, grid)) {
                    coordinates = new ArrayList<Integer>(2);
                    coordinates.add(i);
                    coordinates.add(j + 1);
                    q.offer(coordinates);
                    grid[i][j + 1] = 2;
                    lmao++;
                }
                if(isSafe(i, j - 1, grid)) {
                    coordinates = new ArrayList<Integer>(2);
                    coordinates.add(i);
                    coordinates.add(j - 1);
                    q.offer(coordinates);
                    grid[i][j - 1] = 2;
                    lmao++;
                }
            }
            count++;
        }
        if (fresh == 0) {
            return count - 1;
        }
        return -1;

    }
    boolean isSafe(int i, int j, int[][] grid ) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1;
    }
}
