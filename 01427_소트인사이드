import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int num = new Scanner(System.in).nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        while(num>0){
            list.add(num%10);
            num/=10;
        }
        list.sort(Comparator.reverseOrder());
        for (Integer integer : list) System.out.print(integer);
    }
}
