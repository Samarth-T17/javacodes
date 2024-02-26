package UselessDElete;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Codechef {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
    public static void main(String[] args) throws IOException {

        FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        int testCases = in.nextInt();
        while(testCases-- > 0){
            int x = in.nextInt();
            int y = in.nextInt();
            if(x <= y) {
                out.println(1);
            }
            else {
                int n = y + 1;
                int size = x / n;
                int remain = x % n;
                if (remain > 0) {
                    size++;
                }
                out.println(size);
            }

        }
        out.close();
    }
    public static int divide(int x, int y) {
        int n = y + 1;
        int size = x / n;
        int remain = x % n;

        int[] parts = new int[n];
        Arrays.fill(parts, size);
        int max = -1;
        for (int i = 0; i < remain; i++) {
            parts[i] += 1;
            max = Math.max(max, parts[i]);
        }

        return max;
    }
}
class Pair{
    int a;
    int b;
    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}