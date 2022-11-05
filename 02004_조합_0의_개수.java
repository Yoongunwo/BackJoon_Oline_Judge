package BackJoon1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        long five = 0;
        long two = 0;

        long f = 5;
        long t = 2;
        while(a >= f){
            five += a/f;
            f *= 5;
        }
        while(a >= t){
            two += a/t;
            t *= 2;
        }

        f = 5; t = 2;
        while(b >= f){
            five -= b/f;
            f *= 5;
        }
        while(b >= t){
            two -= b/t;
            t *= 2;
        }

        f = 5; t = 2;
        while(a-b >= f){
            five -= (a-b) /f;
            f *= 5;
        }
        while(a-b >= t) {
            two -= (a-b) / t;
            t *= 2;
        }

        System.out.println(Math.min(five, two));
    }
}
