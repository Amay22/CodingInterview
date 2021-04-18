package arrayInterview;

// Question: Rotate Array of length n by order k
// Complexity: O(n)
// Array arr =  [1,2,3,4,5,6]
// Solution done by dividing and diving and reversing the two parts
// ALGORITHM
//1. Divide the array two parts: 1,2,3,4 and 5, 6
//2. Rotate first part: 4,3,2,1,5,6
//3. Rotate second part: 4,3,2,1,6,5
//4. Rotate the whole array: 5,6,1,2,3,4

public class RotateArr {

    private static int[] rotateArr(int[] arr, int order) {
        if (arr == null || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }
        order = order % arr.length;
        //length of first part
        int start_2_order = arr.length - order;
        reverseArr(arr, 0, start_2_order - 1);
        reverseArr(arr, start_2_order, arr.length - 1);
        reverseArr(arr, 0, arr.length - 1);
        return arr;
    }

    private static void reverseArr(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int result[] = rotateArr(arr, 15);
        for (int num : result) {
            System.out.print(num + ",");
        }
    }
}
