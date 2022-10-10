import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main{
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    void hanoi(int num, int start, int goal) throws IOException{
        if(num < 1) return;

        int via =0;
        if(start == 1 && goal == 2) via =3;
        else if( start ==1 && goal == 3) via =2;
        else if( start ==2 && goal == 1) via =3;
        else if( start ==2 && goal == 3) via =1;
        else if( start ==3 && goal == 1) via =2;
        else if( start ==3 && goal == 2) via =1;

        hanoi(num-1, start, via);
        bw.write( + start + " " + goal + "\n");
        hanoi(num-1, via, goal);
    }
    public static void main(String[] args) throws IOException {
        int num = new Scanner(System.in).nextInt();
        Main m = new Main();
        System.out.println((int)Math.pow(2,num)-1);
        m.hanoi(num,1 , 3);
        m.bw.flush();
    }
}
