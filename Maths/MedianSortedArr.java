
package Maths;


public class MedianSortedArr {

    public static double findMedianSortedArrays(int A[], int B[]) {
        if ((A.length + B.length) % 2 != 0) { // odd
            return (double) findKth(A, B, (A.length + B.length) / 2, 0, A.length - 1, 0, B.length - 1);
        } else { // even
            return (findKth(A, B, (A.length + B.length) / 2, 0, A.length - 1, 0, B.length - 1)
                    + findKth(A, B, (A.length + B.length) / 2 - 1, 0, A.length - 1, 0, B.length - 1)) * 0.5;
        }
    }

    private static int findKth(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd) {
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;
// Handle special cases
        if (aLen == 0) {
            return B[bStart + k];
        }
        if (bLen == 0) {
            return A[aStart + k];
        }
        if (k == 0) {
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
        }
        int aMid = aLen * k / (aLen + bLen); // a’s middle count
        int bMid = k - aMid - 1; // b’s middle count
// make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;
        if (A[aMid] > B[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }
        return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }
}
