package ArrayInterview;

public class FirstMissingPositive {

    public static int firstMissingPositiveAnd0(int A[], int n) {
        for (int i = 0; i < n; i++) {
// when the ith element is not i
            while (A[i] != i) {
// no need to swap when ith element is out of range [0,n]
                if (A[i] < 0 || A[i] >= n) {
                    break;
                }
// swap elements
                int temp = A[i];
                A[i] = A[temp];
                A[temp] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (A[i] != i) {
                return i;
            }
        }
        return n;
    }
}
