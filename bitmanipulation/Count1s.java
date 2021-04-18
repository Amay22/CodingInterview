package bitmanipulation;

public class Count1s {

    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 1; i < 33; i++) {
            if (getBit(n, i) == true) {
                count++;
            }
        }
        return count;
    }

    public static boolean getBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(15));
    }
}
