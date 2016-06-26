/*
 House Robber Problem. Robber cannot rob adjacent houses in array.
 Get max sum of array elements such that no element is adjacent to one another
 Input :=>   [25, 1, 2, 3, 3, 49]
 Output:=>   25 + 3 + 49 = 77 
 Complexity: 0(n)
 Note: keep adding alternating sequnce and compare it with the other sum.
 */
package ArrayInterview;

public class HouseRobber {

    public static int rob(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int even = 0;
        int odd = 0;
        for (int i = 0; i < num.length; i++) {
            if (i % 2 == 0) {
                even += num[i];                
                even = Math.max(even, odd);                
            } else {                
                odd += num[i];                
                odd = even = Math.max(even, odd);                
            }
        }
        return Math.max(even, odd);
    }

    public static int dp_rob(int num[]) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int[] dp = new int[num.length + 1];
        dp[0] = 0;
        dp[1] = num[0];
        for (int i = 2; i < num.length + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i - 1]);
        }
        return dp[num.length];
    }

    // Another Case with house Robber to consider first and last house seperately
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[1], nums[0]);
        }
//include 1st element, and not last element
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }//not include frist element, and include last element
        int[] dr = new int[n + 1];
        dr[0] = 0;
        dr[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dr[i] = Math.max(dr[i - 1], dr[i - 2] + nums[i]);
        }
        return Math.max(dp[n - 1], dr[n - 1]);
    }

    public static void main(String[] args) {
        int arr[] = {25, 1, 2, 3, 3, 49};
//        System.out.println(rob(arr));
        System.out.println(dp_rob(arr));
        int arr2[] = {10,1,1,10};
        System.out.println(rob(arr2));
    }
}
