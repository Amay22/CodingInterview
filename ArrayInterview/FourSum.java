/*
Retun the set of 4 integers in an array that give a target sum.
Notes: sort the array to remove the pain.
Then traverse with two pointers from left and two from right . the runner technique.
Honestly they will ask it just because they don't want to give you the job.
*/

package ArrayInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FourSum {

    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> hashSet = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int k = j + 1;
                int l = num.length - 1;
                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        temp.add(num[l]);
                        if (!hashSet.contains(temp)) {
                            hashSet.add(temp);
                            result.add(temp);
                        }
                        k++;
                        l--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int ans = 10;
        ArrayList<ArrayList<Integer>> result = fourSum(nums, ans);
        result.stream().map((next) -> {
            next.forEach(num -> System.out.print(num + " ,"));
            return next;
        }).forEach((_item) -> {
            System.out.println("");
        });
    }
}
