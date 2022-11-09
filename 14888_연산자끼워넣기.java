import java.util.Scanner;

public class Main {
    static int[] operation;
    static int[] arr;
    static int max=-1000000000, min=1000000000;
    static int calculate(int result, int op_index, int num_index) {
        switch (op_index) {
            case 0:
                result += arr[num_index];
                break;
            case 1:
                result -= arr[num_index];
                break;
            case 2:
                result *= arr[num_index];
                break;
            case 3:
                result /= arr[num_index];
                break;
        }
        return result;
    }

    static void dfs(int result, int numIndex){
        if(numIndex == arr.length){
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }
        for(int i=0; i<operation.length; i++){
            if(operation[i] != 0){
                operation[i]--;
                dfs(calculate(result, i, numIndex), numIndex+1);
                operation[i]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        operation = new int[4];
        for (int i = 0; i < 4; i++) {
            operation[i] = scanner.nextInt();
        }
        dfs(arr[0],1);
        System.out.print(max + "\n" + min);
    }
}
