package sorting;


public class InsertionSort {

    public static int[] insertion_sort(int arr[]) {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            while ((j >= 0) && (arr[j] > key)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int result[] = insertion_sort(arr);
        for (int num : result) {
            System.out.print(num + ",");
        }
    }
}
