/*
Input Array: Stock prices in order of increasing days. So A[idx] = cost on idx day.
Can buy sell multiple times.
just keep looking for increasing sequence and adding it to profit.
Note: I had doubts; what if the stock price dipped suddenly and then rose. so the consecutive
        sequence didn't lead to an answer. But it did.
Time Complexity : O(n) and space is negligible so it's highly optimal.

Read comments below to understand better.
*/
package arrayInterview;

public class MaxStockMultiple {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int arr[] = {25, 1, 2, 4, 3, 49};
        System.out.println(maxProfit(arr));
    }

}
