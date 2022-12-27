import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		int bag = scanner.nextInt();
		
		int[][] things = new int[num+1][2];
		for(int i=1; i<num+1; i++) {
			things[i][0] = scanner.nextInt();
			things[i][1] = scanner.nextInt();
		}
		
		int[][] dp = new int[num+1][bag+1];
	
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				if(things[i][0] > j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(things[i][1] + dp[i-1][j-things[i][0]],
										dp[i-1][j]);
				}
			}
		}
		System.out.print(dp[num][bag]);
	}
}
