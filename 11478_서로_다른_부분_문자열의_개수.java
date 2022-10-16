import java.util.HashSet;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        String a = new Scanner(System.in).nextLine();
        HashSet<String> set = new HashSet<>();

        for(int i=1; i<=a.length(); i++){
            for(int j=0; j<=a.length()-i; j++){
                String b = a.substring(j,j+i);
                set.add(b);
            }
        }
        System.out.print(set.size());
    }
}
