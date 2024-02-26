package GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/course-schedule
public class CourseSchedule1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        return isNotCyclic(adj);
    }
    boolean isNotCyclic(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[adj.size()];
        for(ArrayList<Integer> cur : adj) {
            for(int now : cur) {
                inDegree[now]++;
            }
        }
        for (int i = 0; i < adj.size(); i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int i = 0;
        int cur;
        while (!q.isEmpty()) {
            cur = q.poll();
            i++;
            for(int child : adj.get(cur)) {
                inDegree[child]--;
                if(inDegree[child] == 0) {
                    q.offer(child);
                }
            }
        }
        return i == adj.size();
    }
}
