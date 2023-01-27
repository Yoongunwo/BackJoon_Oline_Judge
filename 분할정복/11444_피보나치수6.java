import java.util.Scanner;

public class Main{
    static int MOD = 1000000007;
    static long[][] origin = {{1,1}, {1,0}};
    //1000000000000000000
    static long[][] fibonacci(long n, long[][] matrix){
        if(n==0 || n==1) {
            return matrix;
        }
        long[][] result = fibonacci(n/2, matrix);

        result = mul(result, result);

        if(n % 2 ==1){
            result = mul(result, origin);
        }
        return result;
    }
    static long[][] mul(long[][] a, long[][] b){
        long[][] result = new long[2][2];
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                for(int z=0; z<2; z++){
                    result[i][j] += a[i][z] * b[j][z];
                }
                result[i][j] %= MOD;
            }
        }
        return result;
    }
    public static void main(String[] args){
        long n = new Scanner(System.in).nextLong();

        long[][] matrix = {{1,1}, {1,0}};

        System.out.print(fibonacci(n-1, matrix)[0][0]);
    }
}
