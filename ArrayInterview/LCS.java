/*
Longest Common Sequence.
Note: Add to a set and keep checking forward and backward and keep increasing the count.
The space is complexity is huge and so is time.
Note: Input array is unsorted so, this is all case scenario.
Note2: Can sort the array and then check so it will lead to O(nlogn + n) which is better.
Time: 0(n) alongwith o(n) space for set.
*/
package ArrayInterview;

import java.util.HashSet;
import java.util.Set;

public class LCS {

    public static int longestConsecutive(int[] num) {
        // if array is empty, return 0
        if (num.length == 0) {x
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int max = 1;
        for (int e : num) {
            set.add(e);
        }
        for (int e : num) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;
            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,2,3,4,5,6,7,6};
        System.out.println(longestConsecutive(nums));
    }
}
