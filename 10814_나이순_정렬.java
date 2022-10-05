import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();

        String[][] array = new String[num][2];
        for(int i=0; i<num; i++){
            array[i][0] = scanner.next();
            array[i][1] = scanner.next();
            scanner.nextLine();
        }

        Arrays.sort(array, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });
        for(int i=0; i<num; i++){
            System.out.println(array[i][0] + " " + array[i][1]);
        }
    }
}
