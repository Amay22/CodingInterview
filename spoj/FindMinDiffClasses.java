package spoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMinDiffClasses {

    private static int findMinDiff(List<List<Integer>> studentRanks){
        final int numClasses = studentRanks.size();
        final int numStudentsEachClass = studentRanks.get(0).size();
        final int[] last_idx = new int[numClasses];
        // first sort it
        for (final List<Integer> studentRank : studentRanks) {
            Collections.sort(studentRank);
        }
        // Store the global minimum difference
        int minn_diff = Integer.MAX_VALUE;
        // keeping looping through the windows until we reach an end to any class
        while (true) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int classIdx = -1;
            // Loop through all the classes to create window using last_idx for windowing
            for (int i = 0; i < numClasses; i++) {
                // find local max
                max = Math.max(max, studentRanks.get(i).get(last_idx[i]));
                // find local min and update classIdx with the class index if min is least amount in this local window
                if (studentRanks.get(i).get(last_idx[i]) < min) {
                    min = studentRanks.get(i).get(last_idx[i]);
                    classIdx = i;
                }
            }
            // compare global min_diff local difference
            minn_diff = Math.min(minn_diff, max - min);
            last_idx[classIdx]++;
            // break out once we reach the end of a class
            if (last_idx[classIdx] == numStudentsEachClass) {
                break;
            }
        }
        return minn_diff;
    }

    public static void main(String[] args) {
        List<List<Integer>> studentRanks = new ArrayList<>();
        studentRanks.add(new ArrayList<>(Arrays.asList(12,16,67,43)));
        studentRanks.add(new ArrayList<>(Arrays.asList(7, 17, 68, 48)));
        studentRanks.add(new ArrayList<>(Arrays.asList(14, 15,77,54)));
        System.out.println(findMinDiff(studentRanks));

        studentRanks = new ArrayList<>();
        studentRanks.add(new ArrayList<>(Arrays.asList(10,20,30)));
        studentRanks.add(new ArrayList<>(Arrays.asList(40, 50, 60)));
        studentRanks.add(new ArrayList<>(Arrays.asList(70,80,90)));
        studentRanks.add(new ArrayList<>(Arrays.asList(100,110,120)));
        System.out.println(findMinDiff(studentRanks));

    }
}
