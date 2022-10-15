import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void draw1(int num , int i, int j) throws IOException{
        int n = 3;
        while( n <= num){
            if((i%n >= n/3 && i%n < n/3*2) && (j%n >= n/3 && j%n < n/3*2)){
                bw.write(" ");
                return;
            }
            n*=3;
        }
        bw.write("*");
    }

    public static void main(String[] args) throws IOException {
        int num = new Scanner(System.in).nextInt();
        for (int i = 0; i < num; i++) {
            for(int j=0; j< num; j++)
                draw1(num, i, j);
            bw.write("\n");
        }
        bw.flush();
    }
}
