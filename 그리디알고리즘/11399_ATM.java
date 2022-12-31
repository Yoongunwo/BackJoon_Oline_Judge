import java.util.Scanner;

public class Main {
	static int[] arr;
	static void mergeSort(int l, int h) {
		if(h-l <= 0) return;
		int center = (h+l)/2;
		mergeSort(l, center); mergeSort(center+1, h);
		merge(l, center, h);
	}
	static void merge(int l, int center, int h) {
		int i = l;
		int j = center+1;
		int[] newArr = new int[h-l+1];
		int newArrIndex = 0;
		while(true) {
			if(i > center || j > h) break;
			if(arr[i] <= arr[j]) {
				newArr[newArrIndex] = arr[i++];
			}else {
				newArr[newArrIndex] = arr[j++];
			}
			newArrIndex++;
		}
		
		while(i <= center) {
			newArr[newArrIndex++] = arr[i++];
		}
		while(j <= h) {
			newArr[newArrIndex++] = arr[j++];	
		}
		for(int n=0; n<newArr.length; n++) {
			arr[l++] = newArr[n];
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		arr = new int[num];
		for(int i=0; i<arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		mergeSort(0, num-1);
		
		int sum = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			arr[i] = arr[i] + arr[i-1];
			sum += arr[i];
		}
		System.out.println(sum);
		
	}
}
