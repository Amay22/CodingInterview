/*
Find Minimum in an sorted but Rotated Array
Note: Binary Search
Time Complexity O(logn) and Space Complexity negligibility
*/
package ArrayInterview;

public class FindMinRotatedSorted {

    public static int findMin(int[] num, int left, int right) {
        if (left == right) {
            return num[left];
        }
        if ((right - left) == 1) {
            return Math.min(num[left], num[right]);
        }
        int middle = left + (right - left) / 2;        
        if (num[left] < num[right]) { // not rotated
            return num[left];       
        } else if (num[middle] > num[left]) {  // go right side
            return findMin(num, middle, right);           
        } else {  // go left side
            return findMin(num, left, middle);
        }
    }
    public static void main(String[] args) {
        int arr[] = {6,7,8,9,10,1,2,3,4,5};
        System.out.println(findMin(arr, 0, arr.length-1));        
    }
}
