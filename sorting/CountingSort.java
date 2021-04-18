package sorting;

// Counting Sort

public class CountingSort {

    public static int[] counting_sort(int[] arr, int min, int max) {
        int[] count = new int[max - min + 1];
        for (int number : arr) {
            count[number - min]++;
        }
        int z = 0;
        for (int i = min; i <= max; i++) {
            while (count[i - min] > 0) {
                arr[z] = i;
                z++;
                count[i - min]--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int result[] = counting_sort(arr,0,9);
        for (int num : result) {
            System.out.print(num + ",");
        }
    }
}
