package Sorting;


public class RadixSort {

    public static int[] radix_sort(int[] arr) {
        // Loop for every bit in the integers
        for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
            // The array to put the partially sorted array into
            int[] tmp = new int[arr.length];
            // The number of 0s
            int j = 0;

            // Move the 0s to the new array, and the 1s to the old one
            for (int i = 0; i < arr.length; i++) {
                // If there is a 1 in the bit we are testing, the number will be negative
                boolean move = arr[i] << shift >= 0;

                // If this is the last bit, negative numbers are actually lower
                if (shift == 0 ? !move : move) {
                    tmp[j] = arr[i];
                    j++;
                } else {
                    // It's a 1, so stick it in the old array for now
                    arr[i - j] = arr[i];
                }
            }

            // Copy over the 1s from the old array
            for (int i = j; i < tmp.length; i++) {
                tmp[i] = arr[i - j];
            }

            // And now the tmp array gets switched for another round of sorting
            arr = tmp;
        }

        return arr;
    }
    public static void main(String[] args) {
        int arr[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int result[] = radix_sort(arr);
        for (int num : result) {
            System.out.print(num + ",");
        }
    }
}
