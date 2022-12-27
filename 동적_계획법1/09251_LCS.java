import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] arr1;
		char[] arr2;
		
		arr1 = scanner.nextLine().toCharArray();
		arr2 = scanner.nextLine().toCharArray();
		
		int[][] dp = new int[arr1.length+1][arr2.length+1];
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr2.length; j++) {
				if(arr1[i] == arr2[j]) {
					dp[i+1][j+1] = dp[i][j]+1; 
				}else {
					dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
				}
			}
		}
		System.out.println(dp[dp.length-1][dp[0].length-1]);
	}
}
