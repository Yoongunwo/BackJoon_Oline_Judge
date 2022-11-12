package BackJoon1;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    static Vector<Integer> vec;
    static int max = -1000;

    static void Dp(int index, int sum) {
        if (index >= vec.size()) return;
        int num = vec.get(index);
        max = Math.max(max, num);
        max = Math.max(max, sum + num);

        if (num > 0) {
            Dp(index + 1, sum + num);
        }else {
            if (sum + num > 0)
                Dp(index + 1, sum + num);
            else
                Dp(index+1, 0);
        }
    }

    public static void main(String[] args) {
        vec = new Vector<>();
        Scanner scanner = new Scanner(System.in);

        scanner.nextLine();
        String str = scanner.nextLine();
        String[] strArr = str.split(" ");

        int sum = 0;
        for (int i = 0; i < strArr.length; i++) {
            int a = Integer.parseInt(strArr[i]);
            if (a <= 0) {
                if (sum != 0) vec.add(sum);
                sum = 0;
                vec.add(a);
            } else {
                sum += a;
            }
        }
        if (sum != 0) vec.add(sum);

        max = Math.max(max, vec.get(0));
        Dp(1, vec.get(0));
        System.out.print(max);
    }
}
