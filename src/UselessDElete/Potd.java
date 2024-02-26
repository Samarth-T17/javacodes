package UselessDElete;
import java.util.*;

class Potd {
    static ArrayList<Long> nthRowOfPascalTriangle(int n) {

        ArrayList<Long> result = new ArrayList<>();
        if(n == 1) {
            result.add(1L);
            return result;
        }
        if(n == 2) {
            result.add(1L);
            result.add(1L);
            return result;
        }
        n = n - 1;
        Long cur = 1L;
        Long g = 1000000007L;
        result.add(cur);
        Long i = 1L;
        do {
            cur = (cur * (n - i + 1) / i) % g;
            result.add(cur);
            i = i + 1;
        }while (cur != 1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(nthRowOfPascalTriangle(8));
    }
}