import java.util.Scanner;

public class Main {
    static int[][] costOfHouse;
    static int min = 1000000000;

    static void Dp() {
        for (int index = 1; index < costOfHouse.length; index++) {
            for (int i = 0; i < 3; i++) {
                int comparison = 1000000000;
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;
                    comparison = Math.min(comparison, costOfHouse[index - 1][j]);
                }
                costOfHouse[index][i] += comparison;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfHouse = scanner.nextInt();
        scanner.nextLine();

        costOfHouse = new int[numOfHouse][3];
        for (int i = 0; i < costOfHouse.length; i++) {
            String[] str = scanner.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                costOfHouse[i][j] = Integer.parseInt(str[j]);
            }
        }
        Dp();
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, costOfHouse[costOfHouse.length - 1][i]);
        }
        System.out.print(min);
    }
}
