package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://leetcode.com/problems/find-eventual-safe-states/
public class EventualSafeState {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        boolean[] visit = new boolean[graph.length];
        boolean[] pathVisit = new boolean[graph.length];
        int a;
        boolean[] check = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(!visit[i]) {
                dfs(graph, visit, check, i, pathVisit);
            }
        }
        for(int i = 0; i < graph.length; i++) {
            if(check[i]) {
                result.add(i);
            }
        }
        System.out.println(Arrays.toString(pathVisit));
        return result;
    }
    static boolean dfs(int[][] graph, boolean[] visit, boolean[] check, int node, boolean[] pathVisit) {

        if(graph[node].length == 0) {
            check[node] = true;
            return true;
        }
        visit[node] = true;
        pathVisit[node] = true;
        for(int cur : graph[node]) {
            if(!visit[cur]) {
                if(!dfs(graph, visit, check, cur, pathVisit)) {
                    return false;
                }
            }
            else if(pathVisit[node]) {
                return false;
            }
        }
        check[node] = true;
        pathVisit[node] = false;
        return true;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                new int[]{},
                new int[]{0, 2, 3, 4},
                new int[]{3},
                new int[]{4},
                new int[]{}
        };
        System.out.println(eventualSafeNodes(array));
    }
}
