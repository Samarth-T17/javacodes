package GRAPH;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visit = new boolean[image.length][image[0].length];
        traversal(sr, sc, color, image, visit, image[sr][sc]);
        return image;
    }
    void traversal(int i, int j, int c, int[][] grid, boolean[][] visit, int cur) {
        if((i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)) {
            return;
        }
        if(grid[i][j] != cur || visit[i][j]) {
            return;
        }
        visit[i][j] = true;

        grid[i][j] = c;
        traversal(i , j + 1, c, grid, visit, cur);
        traversal(i  , j - 1, c, grid, visit, cur);
        traversal(i + 1, j, c, grid, visit, cur);
        traversal(i - 1, j, c, grid, visit, cur);

    }
}
