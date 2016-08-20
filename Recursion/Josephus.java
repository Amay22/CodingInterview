package Recursion;

// N bottles in circle. We count and remove the 1st then the 2nd bottle consecutively
// which bottle remains in the end ?
public class Josephus {

    private static int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        } else{
            return (josephus(n - 1, k + 1) + k - 1) % n + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(josephus(11, 1 ));
    }
}
