package bitmanipulation;

public class AndRangeNums {

    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n = n & n - 1;
        }
        return m & n;
    }
}
