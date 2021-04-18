package hard;

import java.util.ArrayList;

public class PascalsTriangleKth {

    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>();
        if (rowIndex < 0) {
            return result;
        }
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> result = getRow(10);
        result.forEach((num) -> {
            System.out.print(num + ",");
        });
    }
}
