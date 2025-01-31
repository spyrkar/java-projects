package gr.aueb.cf.project;

public class Project2 {

    public static void main(String[] args) {
        int globalMax = Integer.MIN_VALUE;
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        if (arr == null || arr.length == 0) {
            System.out.println("Ο πίνακας πρέπει να περιέχει τιμές. Δεν γίνεται να είναι κενός!");
        }

        globalMax = getMaxSubArray(arr);
        System.out.printf("The Maximum Sum of Subarray is: %d.", globalMax);
    }

    public static int getMaxSubArray(int[] arr) {
        int localMax = arr[0];
        int globalMax = arr[0];

        for(int i = 1; i <= arr.length - 1; ++i) {
            if (localMax + arr[i] > arr[i]) {
                localMax += arr[i];
            } else {
                localMax = arr[i];
            }

            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        return globalMax;
    }
}
