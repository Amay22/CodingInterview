package hard;

import java.util.ArrayList;

public class TriangleMax {

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] total = new int[triangle.size()];
        int l = triangle.size() - 1;
        for (int i = 0; i < triangle.get(l).size(); i++) {
            total[i] = triangle.get(l).get(i);
        }
// iterate from last second row
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
                total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);

            }
        }
        return total[0];
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(2);
        triangle.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(3);
        tmp.add(4);
        triangle.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(6);
        tmp.add(5);
        tmp.add(7);
        triangle.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(4);
        tmp.add(1);
        tmp.add(8);
        tmp.add(3);
        triangle.add(tmp);
        System.out.println(minimumTotal(triangle));

    }
}
