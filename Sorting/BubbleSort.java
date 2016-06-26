package Sorting;


public class BubbleSort {

    public static int[] bubble_sort(int arr[]) {
        boolean swapped = true;
        for (int i = arr.length - 1; i >= 0 && swapped; --i) {
            swapped = false;
            for (int j = 0; j < i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int result[] = bubble_sort(arr);
        for (int num : result) {
            System.out.print(num + ",");
        }
    }
}
