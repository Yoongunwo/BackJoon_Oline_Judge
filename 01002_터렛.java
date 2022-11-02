import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = scanner.nextInt();
        scanner.nextLine();

        while (num-- > 0) {
            int[] loc1 = new int[2];
            int[] loc2 = new int[2];
            int dis1, dis2;

            loc1[0] = scanner.nextInt();
            loc1[1] = scanner.nextInt();
            dis1 = scanner.nextInt();
            loc2[0] = scanner.nextInt();
            loc2[1] = scanner.nextInt();
            dis2 = scanner.nextInt();
            scanner.nextLine();
            double distance = Math.sqrt(Math.pow(loc1[0] - loc2[0], 2) + Math.pow(loc1[1] - loc2[1], 2));
            if (distance == 0) {
                if (dis1 == dis2) sb.append(-1);
                else sb.append(0);
            } else {
                if (distance == dis1 + dis2) sb.append(1);
                else if (distance < dis1 + dis2){
                    int result = Math.abs(dis1-dis2);
                    if (result == distance) sb.append(1);
                    else if (result < distance ) sb.append(2);
                    else sb.append(0);
                }
                else sb.append(0);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
