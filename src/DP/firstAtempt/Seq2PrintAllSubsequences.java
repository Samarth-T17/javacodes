package DP.firstAtempt;

import java.util.ArrayList;

public class Seq2PrintAllSubsequences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        subFun(arr, ans, 0, new ArrayList<>());
        System.out.println(ans);
        System.out.println(ans.size());
    }
    static void subFun(int arr[], ArrayList<ArrayList<Integer>> ans, int i, ArrayList<Integer> cur) {
        if(i >= arr.length) {
            return;
        }
        cur.add(arr[i]);
        ans.add(new ArrayList<>(cur));
        subFun(arr, ans, i + 1, cur);
        cur.remove(cur.size() - 1);
        subFun(arr, ans, i + 1, cur);
    }
}
