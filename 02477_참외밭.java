import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();

        int[][] move = new int[6][2];
        int max_width =0;
        int max_height =0;
        for(int i=0; i < move.length; i++){
            move[i][0] = scanner.nextInt();
            move[i][1] = scanner.nextInt();
            scanner.nextLine();
            if (move[i][0] == 1 || move[i][0] == 2) {
                if (max_width < move[i][1]) max_width = move[i][1];
            } else max_height = Math.max(max_height, move[i][1]);
        }
        for(int i=0; i<move.length; i++){
            int a = i+2;
            if(a>5) a -= 6;
            int b = i -1;
            if(b<0) b += 6;
            int c = i+1;
            if(c>5) c -= 6;

            if(move[i][0] == move[a][0] && move[c][0] == move[b][0]){
                System.out.print((max_width*max_height - move[i][1]*move[c][1])*num);
            }
        }
    }
}
