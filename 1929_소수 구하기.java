// Using Sieve-of-Eratosthenes

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n+1];
        int i =1;
        while(i++ < n){
            if(arr[i] == 0){
                if(i >= m) bw.write(i + "\n");
                int mul = 2;
                for(int j=i*mul++; j<=n; j=i*mul++){
                    arr[j] = 1;
                }
            }
        }
        bw.flush();
    }
}
