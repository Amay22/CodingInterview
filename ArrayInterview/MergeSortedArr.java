/*
Merge sorted Array No eplanation required.
Time: o(2n)
*/
package ArrayInterview;

public class MergeSortedArr {

    private static int[] merge(int A[], int B[]) {
        int i = A.length - 1;
        int j = B.length - 1;
        int k = i + j + 1;        
        int result[] = new int[k--];
        while (k >= 0) {
            if (j < 0 || (i >= 0 && A[i] > B[j])) {
                result[k--] = A[i--];
            } else {
                result[k--] = B[j--];
            }
        }        
        return result;
    }

    public static void main(String[] args) {
        int arr1[] = {5, 34, 78, 222, 345, 999, 1023};
        int arr2[] = {2, 3, 79, 200, 220, 1000, 1111};
        int result[] = merge(arr1, arr2);
        for (int aResult : result) {
            System.out.print(aResult + ",");
        }
    }
}
