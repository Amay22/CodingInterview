package ArrayInterview;
// Java program to find the maximum repeating number 

class MaxRepeating {

    // Returns maximum repeating element in arr[0..n-1].
    // The array elements are in range from 0 to k-1
    static int maxRepeating(int arr[]) {
        // Iterate though input array, for every element
        // arr[i], increment arr[arr[i]%k] by k
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        max++;
        for (int i = 0; i < arr.length; i++) {
            arr[(arr[i] % max)] += max;
        }        
        // Find index of the maximum repeating element
        int repeating = arr[0], result = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > repeating) {
                repeating = arr[i];
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {2, 7, 3, 7, 3, 3, 5, 3, 7, 7};
        System.out.println("Maximum repeating element is: " + maxRepeating(arr));
    }
}
