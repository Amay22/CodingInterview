package Hard;


import java.util.ArrayList;

public class CombinationSum {

    public static ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(result, 1, n, list, k);
        return result;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> result, int start, int sum, ArrayList<Integer> list, int k) {
        if (sum == 0 && list.size() == k) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            result.add(temp);
        }
        for (int i = start; i <= 9; i++) {
            if (sum - i < 0) {
                break;
            }
            if (list.size() > k) {
                break;
            }
            list.add(i);
            dfs(result, i + 1, sum - i, list, k);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = combinationSum3(3,9);
        result.stream().map((next) -> {
            next.forEach(num->System.out.print(num+" ,"));
            return next;
        }).forEach((_item) -> {
            System.out.println("");
        });
    }
}
