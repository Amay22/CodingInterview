package ArrayInterview;

// Find the Nth largest number in an array.
// Algorithm: QuickSelect

public class NthLargestNumber {

    private static int findNthLargest(int[] nums, int n) {
        if (n < 1 || nums == null) {
            return 0;
        }

        return getNth(nums.length - n +1, nums, 0, nums.length - 1);
    }

    private static int getNth(int n, int[] nums, int start, int end) {

        int pivot = nums[end];

        int left = start;
        int right = end;

        while (true) {

            while (nums[left] < pivot && left < right) {
                left++;
            }

            while (nums[right] >= pivot && right > left) {
                right--;
            }

            if (left == right) {
                break;
            }

            swap(nums, left, right);
        }

        swap(nums, left, end);

        if (n == left + 1) {
            return pivot;
        } else if (n < left + 1) {
            return getNth(n, nums, start, left - 1);
        } else {
            return getNth(n, nums, left + 1, end);
        }
    }

    private static void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }
    public static void main(String[] args) {
        System.out.println(findNthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
