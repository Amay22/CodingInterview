package sorting;

public class MergeSortRecursive {

    public static int[] mergeSort(int[] array, int llim, int hlim) {
        if (llim < hlim) {
            int mlim = (llim + hlim) / 2;
            mergeSort(array, llim, mlim);
            mergeSort(array, mlim + 1, hlim);
            merge(array, llim, mlim, hlim);
        }
        return array;
    }

    public static void merge(int[] array, int llim, int mlim, int hlim) {
        /* Additional Helper Arrays */
        int larraySize = mlim - llim + 1;
        int rarraySize = hlim - mlim;
        int[] larray = new int[larraySize + 1];
        int[] rarray = new int[rarraySize + 1];

        /* Sentinel values, to avoid additional checks
         when we are merging larray and rarray */
        larray[larraySize] = Integer.MAX_VALUE;
        rarray[rarraySize] = Integer.MAX_VALUE;

        for (int i = 0; i < larraySize; ++i) {
            larray[i] = array[llim + i];
        }
        for (int i = 0; i < rarraySize; ++i) {
            rarray[i] = array[i + mlim + 1];
        }

        /* Building the resulting array from the previously sorted sequences */
        for (int m = 0, n = 0, k = llim; k <= hlim; ++k) {
            if (larray[m] <= rarray[n]) {
                array[k] = larray[m];
                m++;
            } else {
                array[k] = rarray[n];
                n++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int result[] = mergeSort(array, 0, array.length - 1);
        for (int num : result) {
            System.out.print(num + ",");
        }
    }
}
