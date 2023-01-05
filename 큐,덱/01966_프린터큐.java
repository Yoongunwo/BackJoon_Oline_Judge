import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testNum = scanner.nextInt();
		
		StringBuilder sb = new StringBuilder();
		while(testNum-- > 0) {
			int fileNum = scanner.nextInt();
			int findIndex = scanner.nextInt();
			
			int[][] arr = new int[fileNum][2];
			for(int i=0; i<arr.length; i++) {
				arr[i][0] = scanner.nextInt();
			}
			
			int maxIndex = 0;
			int result = 0;
			while(arr[findIndex][1] != 1) {
				int count = 0;
				int max = 0;
				
				int i = maxIndex;
				while(count != arr.length) {
					if(i == arr.length) i = 0;
					if(arr[i][1] == 0) {
						if(max < arr[i][0] ) {
							max = arr[i][0];
							maxIndex = i;
						}
					}
					i++;
					count++;
				}
				arr[maxIndex][1] = 1;
				result++;
			}
			sb.append(result + "\n");
		}
		System.out.print(sb);
	}
}
