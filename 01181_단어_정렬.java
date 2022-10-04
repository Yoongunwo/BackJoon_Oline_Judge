import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] arr = new String[num];
        scanner.nextLine();
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                else return o1.length() - o2.length();
            }
        });
        String temp = null;
        for(String s : arr) {
            if(!(s.equals(temp))) {System.out.println(s); temp = s;}
        }
    }
}
