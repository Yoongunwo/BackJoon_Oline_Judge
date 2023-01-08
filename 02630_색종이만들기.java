import java.util.Scanner;

public class Main{
	static int[][] matrix;
	static int white = 0;
	static int blue = 0;
	
	static void check(int startRow, int startCol, int endRow, int endCol) {
		if(startRow == endRow-1) {
			if(matrix[startRow][startCol] == 0) white++;
			else blue++;
			return;
		}
		int w = 0;
		int b = 0;
		for(int i=startRow; i<endRow; i++) {
			for(int j=startCol; j<endCol; j++) {
				if(matrix[i][j] == 0) w++;
				else b++;
				if(w*b != 0) break;
			}
			if(w*b != 0) break;
		}
		if(w*b == 0) {
			if(w != 0) white++;
			else blue++;
		}else {
			check(startRow, startCol, (startRow+endRow)/2 , (startCol+endCol)/2 );
			check(startRow, (startCol+endCol)/2, (startRow+endRow)/2 , endCol);
			check((startRow+endRow)/2, startCol, endRow, (startCol+endCol)/2 );
			check((startRow+endRow)/2, (startCol+endCol)/2, endRow, endCol);
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		matrix = new int[num][num];
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		check(0,0,num,num);
		System.out.print(white +"\n" + blue);
	}
}
