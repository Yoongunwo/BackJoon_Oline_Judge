import java.util.Scanner;
import java.util.Vector;

public class Main {
    static Vector<Long> vec;

    static Long padovan(int n, int index, int min) {
        if (n <= vec.size()) return vec.get(n - 1);
        if (vec.size() > index + 1) return padovan(n, index + 1, min + 1);
        else {
            vec.add(vec.get(index) + vec.get(min));
            return padovan(n, index + 1, min + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        vec = new Vector<>();
        vec.add(1L);
        vec.add(1L);
        vec.add(1L);
        vec.add(2L);
        vec.add(2L);

        while (test-- > 0) {
            int n = scanner.nextInt();
            System.out.println(padovan(n, 4, 0));
        }
    }
}
