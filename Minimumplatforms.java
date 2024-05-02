/*1. Minimum platforms 
Given the number of trains and their arrival/departure times at a railway station, find the minimum number of platforms required for the railway station so that no train is kept waiting. Arrival and departure time can never be the same for a train, but we can have arrival time of one train equal to departure time of the other. At any given instance of time, the same platform cannot be used for both departure of a train and arrival of another train. In such cases, we need different platforms. 
Example:
Input:
No. of trains: N = 6 
Arrival times: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00} 
Departure times: dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00} 
Output:
No. of platforms needed: P = 3
*/
import java.util.*;

class Main {
    public  static int findPlatform(int arr[], int dep[], int N){
        // Sort the arrival times
        Arrays.sort(arr);
        // Sort the departure times 
        Arrays.sort(dep);
        // At least they need one platforms
        int platformsNeeded = 1;
        int maxPlatforms = 1;
        // So first will be always in one platform so it will be one
        int i = 1; // arrival time array index
        int j = 0; // departure time array index
        while (i < N && j < N) {
            // It will be checking arrival time is less than or equal to departure time then platformsNeeded will be increase then move to next arrival time
            if (arr[i] <= dep[j]) {
                platformsNeeded++;
                i++;
                // Count the maximum number platforms
                if (platformsNeeded > maxPlatforms) {
                    maxPlatforms = platformsNeeded; 
                }
            }
            // If the previous train departure then platformsNeeded will be decrease then move to next departure time
            else {
                platformsNeeded--; 
                j++;
            }
        }
        return maxPlatforms;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // No. of trains as input
        System.out.print("No. of trains: N = ");
        int N = scanner.nextInt();
        // Arrival times as input
        System.out.println("Arrival times: ");
        int arr[]= new int[N];
        for(int i=0;i<N;i++){
            arr[i]=scanner.nextInt();
        }
        // Departure times as input
        System.out.println("Departure times: ");
        int dept[]=new int[N];
        for(int i=0;i<N;i++){
            dept[i]=scanner.nextInt();
        }           
        // findPlatform will be find the minimum number platformsNeeded
        System.out.println("No. of platforms needed: P = "+findPlatform(arr,dept,N));
    }
}
