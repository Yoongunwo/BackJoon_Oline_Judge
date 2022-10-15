import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int num = new Scanner(System.in).nextInt();

        int title = 666;
        int count = 0;
        while(true){
            if(Integer.toString(title).contains("666")) {
                if(++count == num) break;
            }
            title++;
        }
        System.out.print(title);
    }
}
