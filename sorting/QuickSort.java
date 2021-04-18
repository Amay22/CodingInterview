package sorting;

// Select a pivot, normally the middle one
// From both ends, swap elements and make all elements
// on the left less than the pivot and all elements on the right greater than the pivot
// Recursively sort left part and right part

public class QuickSort {

    public static int[] quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || low >= high) {
            return arr;
        }
        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            }
        }
        // recursively sort two sub parts
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int result[] = quickSort(array, 0, array.length - 1);
        for (int num : result) {
            System.out.print(num + ",");
        }
    }
}
