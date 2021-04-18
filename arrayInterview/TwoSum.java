package arrayInterview;

// Question: Given an array of integers, find
// two numbers such that they add up to a specific target number.
// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2


import java.util.HashMap;

public class TwoSum {

    private static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int index = map.get(numbers[i]);
                result[0] = index;
                result[1] = i;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return result;
    }

    //    for sorted array
    private static int[] twoSum_sorted_array(int[] numbers, int target) {
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
                return new int[]{i, j};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 17;
        int result[] = twoSum(arr, sum);
        System.out.println(arr[result[0]]);
        System.out.println(arr[result[1]]);
        System.out.println("For Sorted Array");
        result = twoSum_sorted_array(arr, sum);
        System.out.println(arr[result[0]]);
        System.out.println(arr[result[1]]);
    }
}
