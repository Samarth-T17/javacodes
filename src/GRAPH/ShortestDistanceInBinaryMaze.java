package GRAPH;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-a-binary-maze
public class ShortestDistanceInBinaryMaze {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) {
            return -1;
        }
        int[] source = {0, 0};
        int[] destination = {grid.length - 1, grid.length - 1};
        if(source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }
        int verticalSize = grid.length;
        int horizontalSize = grid[0].length;
        boolean[][] visit = new boolean[verticalSize][horizontalSize];
        visit[source[0]][source[1]] = true;
        Queue<Coordinate> q = new LinkedList<>();
        q.offer(new Coordinate(source[0], source[1]));
        int levelSize;
        int i, j;
        int distance = 1;
        Coordinate cur;
        while (!q.isEmpty()) {
            distance++;
            levelSize = q.size();
            for(int k = 0; k < levelSize; k ++) {
                cur = q.poll();
                j = cur.j;
                i = cur.i;
                if(i + 1 < verticalSize && grid[i + 1][j] != 1 && !visit[i + 1][j]) {
                    if(i + 1 == destination[0] && j == destination[1]) {
                        return distance;
                    }
                    q.offer(new Coordinate(i + 1, j));
                    visit[i + 1][j] = true;


                }
                if(j + 1 < horizontalSize && grid[i][j + 1] != 1 && !visit[i][j + 1]) {
                    if(j + 1 == destination[1] && i == destination[0]) {
                        return distance;
                    }
                    q.offer(new Coordinate(i, j + 1));
                    visit[i][j + 1] = true;

                }
                if(j - 1 >= 0 && grid[i][j - 1] != 1 && !visit[i][j - 1]) {
                    if(j - 1 == destination[1] && i == destination[0]) {
                        return distance;
                    }
                    q.offer(new Coordinate(i, j - 1));
                    visit[i][j - 1] = true;

                }
                if(i - 1 >= 0 && grid[i - 1][j] != 1 && !visit[i - 1][j]) {
                    if(i - 1 == destination[0] && j == destination[1]) {
                        return distance;
                    }
                    q.offer(new Coordinate(i - 1, j));
                    visit[i - 1][j] = true;
                }
                if(j - 1 >= 0 && i + 1 < verticalSize && grid[i + 1][j - 1] != 1 && !visit[i + 1][j - 1]) {
                    if(j - 1 == destination[1] && i + 1 == destination[0]) {
                        return distance;
                    }
                    q.offer(new Coordinate(i + 1, j - 1));
                    visit[i + 1][j - 1] = true;
                }
                if(j + 1 < horizontalSize && i + 1 < verticalSize && grid[i + 1][j + 1] != 1 && !visit[i + 1][j + 1]) {
                    if(j + 1 == destination[1] && i + 1 == destination[0]) {
                        return distance;
                    }
                    q.offer(new Coordinate(i + 1, j + 1));
                    visit[i + 1][j + 1] = true;
                }
                if(i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] != 1 && !visit[i - 1][j - 1]) {
                    if(i - 1 == destination[0] && j - 1== destination[1]) {
                        return distance;
                    }
                    q.offer(new Coordinate(i - 1, j - 1));
                    visit[i - 1][j - 1] = true;
                }
                if(i - 1 >= 0 && j + 1 < verticalSize && grid[i - 1][j + 1] != 1 && !visit[i - 1][j + 1]) {
                    if(i - 1 == destination[0] && j + 1 == destination[1]) {
                        return distance;
                    }
                    q.offer(new Coordinate(i - 1, j + 1));
                    visit[i - 1][j + 1] = true;
                }
            }
        }
        return -1;
    }

}
class Coordinate{
    int i;
    int j;
    Coordinate(int i, int j) {
        this.i = i;
        this.j = j;
    }
}