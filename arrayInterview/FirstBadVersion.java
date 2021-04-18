package arrayInterview;

// Suppose you have n versions [1, 2, ..., n] and you want to
// find out the first bad one
// make least calls to  isBadVersion(int)

public class FirstBadVersion {

    private static boolean isBadVersion(int n){
        return n > 10;
    }

    private static int firstBadVersion(int n) {
        int i = 1, j = n;
        while (i < j) {
            int m = i + (j-i) / 2;
            if (isBadVersion(m)) {
                j = m;
            } else {
                i = m+1;
            }
        }
        if (isBadVersion(i)) {
            return i;
        }
        return j;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(20));
    }
}
