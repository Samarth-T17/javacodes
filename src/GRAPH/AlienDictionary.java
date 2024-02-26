package GRAPH;
//https://practice.geeksforgeeks.org/problems/alien-dictionary/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=alien-dictionary

import java.util.ArrayList;
import java.util.Stack;

public class AlienDictionary {
    static public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < K; i++) {
            adj.add(new ArrayList());
        }
        formGraph(adj, dict);
        boolean[] visit = new boolean[K];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < K; i++) {
            if(!visit[i]) {
                dfs(adj, s, visit, i);
            }
        }
        while(!s.isEmpty()) {
            result.append((char)(s.pop() + 'a')) ;
        }
        return result.toString();
    }
    static void formGraph(ArrayList<ArrayList<Integer>> adj, String[] dict) {
        for(int i = 0; i < dict.length - 1; i++) {
            for(int j = 0; j < dict[i].length() && j < dict[i + 1].length(); j++) {
                if(dict[i].charAt(j) != dict[i + 1].charAt(j)) {
                    adj.get(dict[i].charAt(j) - 'a').add(dict[i + 1].charAt(j) - 'a');
                    break;
                }
            }
        }
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> s, boolean[] visit, int node) {
        visit[node] = true;
        for(int cur : adj.get(node)) {
            if(!visit[cur]) {
                dfs(adj, s, visit, cur);
            }
        }
        s.push(node);
    }

    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        String ans = findOrder(dict, N, K);

        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }
}
