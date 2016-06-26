package ArrayInterview;

public class MinimumSizeSubArray {

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
// initialize min length to be the input array length
        int result = nums.length;
        int i = 0;
        int sum = nums[0];
        for (int j = 0; j < nums.length;) {
            if (i == j) {
                if (nums[i] >= s) {
                    return 1; //if single elem is large enough
                } else {
                    j++;
                    if (j < nums.length) {
                        sum = sum + nums[j];
                    } else {
                        return result;
                    }
                }
            } else {
//if sum is large enough, move left cursor
                if (sum >= s) {
                    result = Math.min(j - i + 1, result);
                    sum = sum - nums[i];
                    i++;
//if sum is not large enough, move right cursor
                } else {
                    j++;
                    if (j < nums.length) {
                        sum = sum + nums[j];
                    } else {
                        if (i == 0) {
                            return 0;
                        } else {
                            return result;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, arr));
    }
}
