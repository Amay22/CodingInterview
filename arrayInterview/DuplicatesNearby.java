/*
Find Duplicates in a specfic in an Unsorted Array
Time Complexity O(n) and Space Complexity O(n)
*/
package arrayInterview;

import java.util.HashMap;

public class DuplicatesNearby {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int preIndex = map.get(nums[i]);
                int gap = i - preIndex;
                min = Math.min(min, gap);
            }
            map.put(nums[i], i);
        }
        return min <= k;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,4};
        System.out.println(containsNearbyDuplicate(arr,1));
        System.out.println(containsNearbyDuplicate(arr,2));
    }
}
