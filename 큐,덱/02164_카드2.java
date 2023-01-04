import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		int num = new Scanner(System.in).nextInt();
		int[] arr= new int[num];
		
		int arrIndex = 0;
		boolean flag = false;
		while(num != 1) {
			
			if(arrIndex == arr.length)
				arrIndex = 0;
			if(arr[arrIndex] == 1) {
				arrIndex++;
				continue;
			}
			if(!flag) {
				arr[arrIndex] = 1;
				num--;
			}
			flag = !flag;
			arrIndex++;
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 0) {
				System.out.print(i+1);
				break;
			}
		}
	}
}
