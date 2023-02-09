import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int numHouse;
    static int numWifi;
    static int[] locationHouse;
    static int[] locationWifi;

    static int findDistance() {
        int low = 0;
        int high = locationHouse[locationHouse.length - 1];
        while (low < high) {
            int mid = (high + low) /2;
            if(installWifi(mid) < numWifi){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    static int installWifi(int distance) {
        int lastLocation = locationHouse[0];
        int wifi = 1;
        for (int i = 1; i < numHouse; i++) {
            if ((locationHouse[i] - lastLocation) >= distance) {
                wifi++;
                lastLocation = locationHouse[i];
            }
        }
        return wifi;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        numHouse = scanner.nextInt();
        numWifi = scanner.nextInt();

        locationHouse = new int[numHouse];
        for (int i = 0; i < numHouse; i++) {
            locationHouse[i] = scanner.nextInt();
        }
        Arrays.sort(locationHouse);
        System.out.print(findDistance() - 1);
    }
}
