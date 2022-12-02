import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++){
            arr[i] = scanner.nextInt();
        }

        int[] ascent = new int[num];
        int[] descent = new int[num];
        for(int i=0; i<num; i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    ascent[i] = Math.max(ascent[i], ascent[j]);
                }
                if(arr[num-i-1] > arr[num-j-1]){
                    descent[num-i-1] = Math.max(descent[num-i-1], descent[num-j-1]);
                }
            }
            ascent[i] +=1;
            descent[num-i-1] +=1;
        }
        int max = 0;
        for(int i=0; i<num; i++){
            max = Math.max(ascent[i]+descent[i], max);
        }
        System.out.print(max-1);
    }
}
