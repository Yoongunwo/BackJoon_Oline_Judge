import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numHouse = scanner.nextInt();
        int numWifi = scanner.nextInt();

        int[] locationHouse = new int[numHouse];
        for(int i=0; i<numHouse; i++) {
            locationHouse[i] = scanner.nextInt();
        }
        Arrays.sort(locationHouse);

        int low = 1;
        int high = locationHouse[numHouse - 1] - locationHouse[0] + 1;

        while(high > low){
            int mid = (high+low)/2;

            int lastLocation = locationHouse[0];
            int wifi = 1;
            for(int i=1; i<numHouse; i++){
                if((locationHouse[i] - lastLocation) >= mid){
                    lastLocation = locationHouse[i];
                    wifi++;
                }
            }

            if(wifi < numWifi){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        System.out.print(low - 1);
    }
}
