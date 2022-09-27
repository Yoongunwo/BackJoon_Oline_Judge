
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n;
        while((n=scanner.nextInt()) != 0){
            int sum = 0;
            int[] arr = new int[2*n+1];
            for(int i=2; i<arr.length; i++){
                if(arr[i] == 0){
                    if(i>n) sum++;
                    int mul = 2;
                    for(int j=mul*i; j<arr.length; j=++mul*i) arr[j] = 1;
                }
            }
            System.out.println(sum);
        }
        System.out.print(Math.sqrt(13));
    }
}
