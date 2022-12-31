import java.util.Scanner;

public class Main{
	static long[][] arr;
	
	static void mergeSort(int l, int h, int index) {
		if(h-l <= 0) {
			return;
		}
		int center = (h+l)/2;
		mergeSort(l, center, index); mergeSort(center+1, h, index);
		merge(l, center, h, index);
    }
	
	static void merge(int l, int center, int h, int index) {
		int i = l;
		int j = center+1;
		long[][] newArr = new long[h-l+1][2];
		int newArrIndex = 0;
		while(true) {
			if(i > center || j > h) break;
			if(arr[i][index] <= arr[j][index]) {
				newArr[newArrIndex][0] = arr[i][0];
				newArr[newArrIndex][1] = arr[i][1];
				i++;									
			}else {
				newArr[newArrIndex][0] = arr[j][0];
				newArr[newArrIndex][1] = arr[j][1];
				j++;
			}
			newArrIndex++;
		}
		while(i <= center) {
			newArr[newArrIndex][0] = arr[i][0];
			newArr[newArrIndex][1] = arr[i][1];
			i++;	
			newArrIndex++;
		}
		while(j <= h) {
			newArr[newArrIndex][0] = arr[j][0];
			newArr[newArrIndex][1] = arr[j][1];
			j++;
			newArrIndex++;
		}
		for(int n=0; n<newArr.length; n++, l++) {
			arr[l][0] = newArr[n][0];
			arr[l][1] = newArr[n][1];
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		arr = new long[num][2];
		
		for(int i=0; i<num; i++) {
			arr[i][0] = scanner.nextLong();
			arr[i][1] = scanner.nextLong();
		}
		mergeSort(0, num-1, 0);
	    System.gc();
        mergeSort(0, num-1, 1);
		
		int count = 0;
		long time = 0;
		for(int i=0; i<num; i++) {
			if(arr[i][0] >= time) {
				count++;
				time = arr[i][1];
			}
		}
		System.out.println(count);
	}
}
