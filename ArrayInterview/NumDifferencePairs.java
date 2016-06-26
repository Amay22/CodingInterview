package ArrayInterview;

import java.util.HashSet;
import java.util.Set;

public class NumDifferencePairs {

    public static int differnce_paris(int target, int arr[]) {
        Set<Integer> set = new HashSet<>();
        for (int e : arr) {
            set.add(e);
        }
        int count = 0;
        for (int e : arr) {
            count += set.contains(target + e) ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int target = 2;
        System.out.println(differnce_paris(target, arr));
    }

}
