/*
 Get Alternating large and small values in an array
 Input :=>   [a1,a2,a3,a4,a5,....]
 Output:=>   [a1 <= a2 >= a3 <= a4 >= a5 <= .....]
 Complexity => O(n)
 Notes : Strong desire to sort the array but this works in o(n) so...
 */
package arrayInterview;

public class AlternatingArray {

    private static int[] alternate_unsorted(int arr[]) {
        for (int i = 0; i < arr.length - 1; ++i) {
            if (i % 2 == 0 && arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            } else if (i % 2 == 1 && arr[i] < arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
        return arr;
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {25, 1, 2, 3, 3, 49, 54, 32, 67, 22, 13};
        int result[] = alternate_unsorted(arr);
        for (int aResult : result) {
            System.out.print(aResult + ", ");
        }
    }
}
