import java.util.Scanner;

public class Main{
    static final int MOD = 1000000007;
    public static long factorial(int n){
        long result =1;
        for(int i=2; i<=n; i++){
            result *= i;
            result %= MOD;
        }
        return result;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long a = factorial(n);

        long b = factorial(k);
        b = b * factorial(n-k) % MOD;
        

        long result = 1;
        for(int i=MOD-2; i>0; i/=2){
            if(i %2 == 1){
                result *= b;
                result %= MOD;
            }
            b *= b;
            b %= MOD;
        }
        System.out.print(a*result%MOD);
    }
}
