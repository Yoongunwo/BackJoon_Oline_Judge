import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] arr = new int[num][2];
        for(int i=0; i<num; i++){
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            scanner.nextLine();
        }

        for(int i=0; i<arr.length; i++){
            int count = 0;
            for(int j=0; j<arr.length; j++){
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
                    count++;
            }
            System.out.print(count+1 + " ");
        }
    }
}
