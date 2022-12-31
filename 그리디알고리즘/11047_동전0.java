package back2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int kinds = scanner.nextInt();
		int money = scanner.nextInt();
		
		int[] arr = new int[kinds];
		for(int i=0; i<arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		
		int sum = 0;
		int count = 0;
		
		while(true) {
			for(int i=arr.length-1; i>=0 ;i--) {
				if(money > sum + arr[i]) {
					count++;
					sum += arr[i];
					break;
				}
			}
			if(money == sum) break;
		}
		System.out.println(count);
	}
}
