package GRAPH;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/bipartite-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bipartite-graph
public class BipartiteDFS {
//    public boolean isBipartiteDFS(ArrayList<ArrayList<Integer>> graph) {
//        int[] colour = new int[graph.length];
//
//        for(int i = 0; i < graph.size(); i++) {
//            if(colour[i] != 0){
//                if(!dfs(graph, colour, -1, i)) {
//                    return false;
//                }
//            }
//
//        }
//        return true;
//    }
//    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] colour, int parentColour, int node) {
//        if(colour[node] != 0 ){
//            return colour[node] != parentColour;
//        }
//
//        int childColour;
//        if(parentColour == 1) {
//            childColour = 2;
//        }
//        else {
//            childColour = 1;
//        }
//        colour[node] = childColour;
//        for(int child : adj.get(node)) {
//            if(!dfs(adj, colour, childColour, child)){
//                return false;
//            }
//        }
//        return true;
//    }
}
