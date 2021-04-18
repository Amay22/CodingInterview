package bitmanipulation;

public class SingleNumber {

    public static int singleNumber(int[] A) {
        int x = 0;
        for (int a : A) {
            x = x ^ a;
        }
        return x;
    }

    public static void main(String[] args) {
        int num[] = {1, 1, 3, 2, 3, 4, 4};
        System.out.println(singleNumber(num));
    }
}
