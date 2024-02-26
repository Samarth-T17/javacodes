package GRAPH;
// https://leetcode.com/problems/course-schedule-ii/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        return isNotCyclic(adj);
    }
    int[] isNotCyclic(ArrayList<ArrayList<Integer>> adj) {
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
        int[] result = new int[adj.size()];
        while (!q.isEmpty()) {
            cur = q.poll();
            result[i] = cur;
            i++;
            for(int child : adj.get(cur)) {
                inDegree[child]--;
                if(inDegree[child] == 0) {
                    q.offer(child);
                }
            }
        }
        if(i == adj.size()) {
            return result;
        }
        return new int[]{};
    }

}
