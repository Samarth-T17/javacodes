package GRAPH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Routes {
    public static void main(String[] args) {
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        System.out.println(numBusesToDestination(routes, 1, 6));
    }
    public static int numBusesToDestination(int[][] routes, int source, int target) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int curNode;
        ArrayList<Integer> cur;
        int same = 0;
        for(int i = 0; i < routes.length; i++) {
            same = 0;
            for(int j = 0; j < routes[i].length; j++) {
                curNode = routes[i][j];
                if(curNode == source || curNode == target) {
                    if(same == 1) {
                        return 1;
                    }
                    same = 1;
                }
                cur = map.get(curNode);
                if(cur == null) {
                    cur = new ArrayList<>();
                    map.put(curNode, cur);
                }
                cur.add(routes[i][(j + 1) % routes[i].length]);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        HashMap<Integer, Boolean> visitMap = new HashMap<>();
        visitMap.put(source, true);
        HashMap<Integer, Integer> distanceMap = new HashMap<>();
        distanceMap.put(source, 0);
        int curDistance;
        boolean flag = false;
        int bus = 0;
        while (!q.isEmpty()) {
            curNode = q.poll();
            cur = map.get(curNode);
            curDistance = distanceMap.get(curNode);
            for (int child : cur) {
                if(flag) {
                    bus++;
                }
                flag = true;

                if(distanceMap.get(child) == null) {
                    distanceMap.put(child, curDistance + 1);
                }
                else if(curDistance + 1 < distanceMap.get(child)) {
                    distanceMap.put(child, curDistance + 1);
                }
                if((visitMap.get(child) == null)){
                    q.offer(child);
                    visitMap.put(child, true);
                }
                if(child == target) {
                    break;
                }
            }
        }
        return distanceMap.get(target) == null ? -1 : bus ;
    }
}
