/*
Find Minimum in an sorted but Rotated Array with duplicates
Note: Binary Search
Time Complexity O(logn) and Space Complexity negligibility
*/

package ArrayInterview;

public class FindMinRotatedSortedDuplicates {

    public static int findMin(int[] num, int left, int right) {
        if (right == left) {
            return num[left];
        }
        if (right == left + 1) {
            return Math.min(num[left], num[right]);
        }
        int middle = (right - left) / 2 + left;
        if (num[right] > num[left]) {
            return num[left];
        } else if (num[right] == num[left]) {
            return findMin(num, left + 1, right);
        } else if (num[middle] >= num[left]) {
            return findMin(num, middle, right);
        } else {
            return findMin(num, left, middle);
        }
    }
     public static void main(String[] args) {
        int arr[] = {6,7,8,8,9,10,1,1,2,3,4,5};
        System.out.println(findMin(arr, 0, arr.length-1));        
    }
}
