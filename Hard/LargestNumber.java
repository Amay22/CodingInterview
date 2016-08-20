package Hard;

// largest number that can be formed by concatenation all the numbers in an array.

import java.util.Arrays;

public class LargestNumber {

    private static String largestNumber(int[] num) {
        String[] NUM = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            NUM[i] = String.valueOf(num[i]);
        }
        Arrays.sort(NUM, (String left, String right) -> {
            String leftRight = left.concat(right);
            String rightLeft = right.concat(left);
            return rightLeft.compareTo(leftRight);
        });
        StringBuilder sb = new StringBuilder();
        for (String NUM1 : NUM) {
            sb.append(NUM1);
        }
        java.math.BigInteger result = new java.math.BigInteger(sb.toString());
        return result.toString();
    }
    public static void main(String[] args) {
        int nums[] = {3, 30, 34, 5, 9,955};
        System.out.println(largestNumber(nums));
    }
}
