/*
Input Array: Stock prices in order of increasing days. So A[idx] = cost on idx day.
Parameters are input array and number of times you can buy and sell i.e. k.
This is all case scenrio for this question. If you know this then you know all.  types.
The way it is solved is by using an array for sums on the day for local and global maxima.

Time Complexity : O(n*k) and space is O(2k) so it's highly optimal.

Read comments below to understand better.
*/
package ArrayInterview;

public class MaxStockLimit {

    public static int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k <= 0) {
            return 0;
        }
        int[] local = new int[k + 1];
        int[] global = new int[k + 1];
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; j--) {
                // stores the max sum from start or the current local + diff. whichever is larger
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                // Stores the answer at the particular index if local or global
                // As one can see from both these equations the k Max buy sell diff is being stored
                // so at the end we have only k max diff elements in global and last one is answer.
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[k];
    }

    public static void main(String[] args) {
        int arr[] = {25, 1, 2, 3, 3, 49};
        System.out.println(maxProfit(2, arr));
    }
}
