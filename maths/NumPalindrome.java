package maths;

public class NumPalindrome {

    public static boolean isPalindrome(int x) {
//negative numbers are not palindrome
        if (x < 0) {
            return false;
        }
// initialize how many zeros
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x != 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
