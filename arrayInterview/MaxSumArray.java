/*
Sub Array with Max Sum
Time: O(n)
*/
package arrayInterview;

public class MaxSumArray {

    public static int maxSubArray(int[] A) {
        int newsum = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            newsum = Math.max(A[i], newsum + A[i]);
            max = Math.max(max, newsum);
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));

    }
}
