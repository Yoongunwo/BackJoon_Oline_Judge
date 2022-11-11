import java.util.Scanner;

public class Main {
    static int[][][] arr;
    static int x, y, z;

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return arr[0][0][0] = 1;
        } else if (a > 20 || b > 20 || c > 20) {
            return w(20,20,20);
        }else if(arr[a][b][c] > 0) return arr[a][b][c];
        else if (a < b && b < c)
            arr[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1)
                    - w(a, b-1, c);
        else
            arr[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c)
                    + w(a-1, b, c-1) - w(a-1, b-1, c-1);

        return arr[a][b][c];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        arr = new int[21][21][21];
        while (true) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            z = scanner.nextInt();
            if (x == y && y == z && z == -1) break;
            sb.append("w(" + x + ", " + y + ", " + z + ") = ")
                    .append(w(x, y, z)).append("\n");
        }
        System.out.print(sb);
    }
}
