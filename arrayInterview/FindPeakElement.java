/*
Find Minimum in an sorted but Rotated Array with duplicates
Note: Binary Search
Time Complexity O(n) and Space Complexity negligibility
*/

package arrayInterview;

public class FindPeakElement {

    public int findPeakElement(int[] num) {
        int max = num[0];
        int index = 0;
        for (int i = 1; i <= num.length - 2; i++) {
            int prev = num[i - 1];
            int curr = num[i];
            int next = num[i + 1];
            if (curr > prev && curr > next && curr > max) {
                index = i;
                max = curr;
            }
        }
        if (num[num.length - 1] > max) {
            return num.length - 1;
        }
        return index;
    }

    public static int findPeakUtil(int arr[], int low, int high, int n){
        // Find index of middle element
        int mid = low + (high - low)/2;  /* (low + high)/2 */

        // Compare middle element with its neighbours (if neighbours
        // exist)
        if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 ||
             arr[mid+1] <= arr[mid]))
            return mid;

        // If middle element is not peak and its left neighbor is
        // greater than it,then left half must have a peak element
        else if (mid > 0 && arr[mid-1] > arr[mid])
            return findPeakUtil(arr, low, (mid -1), n);

        // If middle element is not peak and its right neighbor
        // is greater than it, then right half must have a peak
        // element
        else return findPeakUtil(arr, (mid + 1), high, n);
    }

    // A wrapper over recursive function findPeakUtil()
    public static int findPeak(int arr[], int n){
        return findPeakUtil(arr, 0, n-1, n);
    }


    public static void main(String[] args) {

    }
}
