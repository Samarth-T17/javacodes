package GRAPH;
import java.util.*;
public class BipartiteBFS {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] colour = new int[adj.size()];
        for(int i = 0; i < adj.size(); i++) {
            if(colour[i] != 0) {
                if(!bfsOfGraph(adj, colour, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfsOfGraph(ArrayList<ArrayList<Integer>> adj, int[] colour, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        int parent;
        while(!q.isEmpty()) {
            parent = q.poll();
            for(int next : adj.get(parent)){
                if(colour[next] == 0){
                    colour[next] = getColour(parent);
                    q.offer(next);
                }
                else if(colour[next] == colour[parent]) {
                    return false;
                }
            }
        }
        return true;
    }
    int getColour(int n) {
        if(n == 2) {
            return 1;
        }
        return 2;
    }
}
