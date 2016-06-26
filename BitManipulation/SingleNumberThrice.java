package BitManipulation;

public class SingleNumberThrice {

    public static int singleNumber(int[] A) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < A.length; i++) {
            twos |= ones & A[i];
            ones ^= A[i];
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

    public static void main(String[] args) {
        int num[] = {1, 1, 1, 3, 2, 3, 3, 4, 4, 4};
        System.out.println(singleNumber(num));
    }
}
