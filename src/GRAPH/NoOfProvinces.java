package GRAPH;
// https://leetcode.com/problems/number-of-provinces/
public class NoOfProvinces {
    static int count = 0;
    public int findCircleNum(int[][] isConnected) {
        count = 0;
        boolean[] visit = new boolean[isConnected.length];
        for(int i = 0; i < isConnected.length; i++) {
            if(!visit[i]) {
                follow(isConnected, i, visit);
                count++;
            }
        }
        return count;
    }
    public void follow(int[][] isConnected, int i, boolean[] visit) {
        if(!visit[i]) {
            visit[i] = true;
            for(int j = 0; j < isConnected.length; j++) {
                if(isConnected[i][j] == 1 ) {
                    follow(isConnected, j, visit);
                }
            }
        }
    }
}
