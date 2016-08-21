package ArrayInterview;

// same as TwoSum but for a sorted array.

public class TwoSumSorted {

    private static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int x = numbers[i] + numbers[j];
            if (x < target) {
                ++i;
            } else if (x > target) {
                j--;
            } else {
                return new int[]{numbers[i],numbers[j]};
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,0};
        int result[] = twoSum(arr, 5) ;
        for(int num: result){
            System.out.print(num+" ,");
        }
    }
}
