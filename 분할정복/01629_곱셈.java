import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static int[] dp;
    static long dfs(int a, int b, int c){
        long result = 0;
        if(b > 1){
            if(b%2 == 0) {
                result = dfs(a, b/2, c);
                result = result * result % c;
            }else{
                result = (long) dfs(a,b / 2, c) * dfs( a,b/2+1, c) % c;
            }
            return result;
        }else{
            return a % c;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.print(dfs(a, b, c));
    }
}
