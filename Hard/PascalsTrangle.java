package Hard;

import java.util.ArrayList;

public class PascalsTrangle {

    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }
        ArrayList<Integer> pre = new ArrayList<>();
        pre.add(1);
        result.add(pre);
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            cur.add(1); //first
            for (int j = 0; j < pre.size() - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1)); //middle
            }
            cur.add(1);//last
            result.add(cur);
            pre = cur;
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = generate(10);
        result.forEach((row)->{
            row.forEach((num)->{
                    System.out.print(num+",");
            });
                System.out.println("");});
    }
}
