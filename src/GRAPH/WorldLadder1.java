package GRAPH;

import java.util.*;

// https://leetcode.com/problems/word-ladder/
public class WorldLadder1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        formGraph(adj, beginWord, wordList);
        int[] distance = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            distance[i] = (int)(1e9);
        }
        boolean[] visit = new boolean[adj.size()];
        visit[0] = true;
        distance[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int curNode;
        while (!q.isEmpty()) {
            curNode = q.poll();
            for (int child : adj.get(curNode)) {
                if(distance[curNode] + 1 < distance[child]) {
                    distance[child] = distance[curNode] + 1;
                }
                if(!visit[child]){
                    q.offer(child);
                    visit[child] = true;
                }

            }
        }
        return distance[adj.size() - 1];
    }
    void formGraph(ArrayList<ArrayList<Integer>> adj, String beginWord, List<String> wordList) {
        int flag = 0;
        int size = wordList.size() + 1;
        if(wordList.contains(beginWord)) {
            size --;
            flag = 1;
        }
        for(int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
        }
        int index = -1;
        if(flag == 1) {
            for(int i = 0; i < wordList.size(); i++) {
                if(beginWord.equals(wordList.get(i))){
                    index = i;
                }
            }
        }
        for(int i = 0; i < wordList.size(); i++) {
            if(check(beginWord, wordList.get(i))) {
                adj.get(0).add(i);
                adj.get(i).add(0);
            }
        }
        for(int i = 0; i < wordList.size() ; i++) {
            if(i == index ) {
                continue;
            }
            for(int j = i + 1; j < wordList.size(); j++) {
                if(j == index ) {
                    continue;
                }
                if(check(wordList.get(j), wordList.get(i))) {
                    adj.get(j).add(i);
                    adj.get(i).add(j);
                }
            }
        }


    }
    boolean check(String a, String b) {
        boolean flag = false;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                if(flag) {
                    return false;
                }
                flag = true;
            }
        }

        return flag;
    }
}
