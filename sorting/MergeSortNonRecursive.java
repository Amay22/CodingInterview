package sorting;


public class MergeSortNonRecursive {

    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        // The size of the sub-arrays . Constantly changing .
        int step = 1;
        int startL, startR;

        while (step < arr.length) {
            startL = 0;
            startR = step;
            while (startR + step <= arr.length) {
                mergeArrays(arr, startL, startL + step, startR, startR + step);
                startL = startR + step;
                startR = startL + step;
            }
            if (startR < arr.length) {
                mergeArrays(arr, startL, startL + step, startR, arr.length);
            }
            step *= 2;
        }
        return arr;
    }

    // Merge to already sorted blocks
    public static void mergeArrays(int[] array, int startL, int stopL,
        int startR, int stopR) {
        // Additional arrays needed for merging
        int[] right = new int[stopR - startR + 1];
        int[] left = new int[stopL - startL + 1];

        // Copy the elements to the additional arrays
        for (int i = 0, k = startR; i < (right.length - 1); ++i, ++k) {
            right[i] = array[k];
        }
        for (int i = 0, k = startL; i < (left.length - 1); ++i, ++k) {
            left[i] = array[k];
        }

        // Adding sentinel values
        right[right.length - 1] = Integer.MAX_VALUE;
        left[left.length - 1] = Integer.MAX_VALUE;

        // Merging the two sorted arrays into the initial one
        for (int k = startL, m = 0, n = 0; k < stopR; ++k) {
            if (left[m] <= right[n]) {
                array[k] = left[m];
                m++;
            } else {
                array[k] = right[n];
                n++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1,0};
        int result[] = mergeSort(array);
         for (int num : result) {
            System.out.print(num + ",");
        }
    }
}
