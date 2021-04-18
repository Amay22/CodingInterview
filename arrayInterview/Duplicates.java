/*
Find Duplicates in an Unsorted Array
*/

package arrayInterview;

import java.util.HashSet;

public class Duplicates {

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,4};
        System.out.println(containsDuplicate(arr));
    }
}
