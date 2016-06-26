package Sorting;


public class SelectionSort {

    public static int[] selection_sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; ++i) {
            int index = i;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int result[] = selection_sort(arr);
        for (int num : result) {
            System.out.print(num + ",");
        }
    }
}
