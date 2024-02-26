public class krh {
    static int b = 0;
    public static void main(String[] args) {
        int[][] mat = {{1,1,1,0,1,1,1,0}, {1,1,1,1,1,1,1,1}, {1,1,1,1,1,1,1,0}};
        int max = 0;
        boolean[][] visit;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                b = 0;
                visit = new boolean[mat.length][mat[0].length];
                dfs(i, j, 0, visit, mat);
                if(max < b) {
                    max = b;
                    System.out.println(i+" "+j);
                }
            }
        }
        System.out.println(max - 1);
        dfs(0,0,0, new boolean[mat.length][mat[0].length], mat);
    }
    static void dfs(int i, int j, int n,boolean[][] visit , int[][] mat) {
        if(!(i < mat.length && j < mat[0].length && i >= 0 && j >= 0 && !visit[i][j] && mat[i][j] == 1)) {
            return;
        }
        System.out.println(i+" "+j+ " "+ b);
        visit[i][j] = true;
        b++;
        dfs(i + 1, j, n, visit, mat);
        dfs(i, j + 1, n,visit, mat);
        dfs(i, j - 1, n,visit, mat);
        dfs(i - 1, j,n, visit, mat);
    }
}
