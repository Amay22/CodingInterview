/*
Input Array: Stock prices in order of increasing days. So A[idx] = cost on idx day.
Can buy onece and sell once. Buy must come before sell
just keep looking for increasing sequence and adding it to profit and use max.
Time Complexity : O(n) and space is negligible so it's highly optimal.

Read comments below to understand better.
*/
package ArrayInterview;

public class MaxStockOnce {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int minElement = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - minElement);
            minElement = Math.min(minElement, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int arr[] = {25, 1, 2, 4, 3, 49};
        System.out.println(maxProfit(arr));
    }
}
