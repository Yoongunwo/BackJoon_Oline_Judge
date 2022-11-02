import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();

        StringBuilder sb = new StringBuilder();
        while(num-- > 0){
            int start[] = new int[2], goal[] = new int[2];
            start[0] = scanner.nextInt(); start[1] = scanner.nextInt();
            goal[0] = scanner.nextInt(); goal[1] = scanner.nextInt();

            int planets = scanner.nextInt();

            int planet[][] = new int[planets][3];
            for(int i=0; i<planet.length; i++){
                for(int j=0; j<planet[0].length; j++){
                    planet[i][j] = scanner.nextInt();
                }
            }
            int count =0;
            for(int i=0; i<planet.length; i++){
                int composition = 0;
                double dis1 = Math.sqrt(Math.pow(start[0]-planet[i][0],2)+Math.pow(start[1]-planet[i][1],2));
                double dis2 = Math.sqrt(Math.pow(goal[0]-planet[i][0],2)+Math.pow(goal[1]-planet[i][1],2));
                if(dis1 < planet[i][2]) composition++;
                if(dis2 < planet[i][2]) composition++;

                if(composition == 1) count++;
            }
            sb.append(count + "\n");
        }
        System.out.print(sb);
    }
}
