package strings;

public class Palindrome {

    private static boolean isPalindrome(String pali) {
        for (int i = 0; i < pali.length()/2; i++) {
            int difference = Math.abs(pali.charAt(i) - pali.charAt(pali.length()-1-i));
            difference = difference == 32 ? 0 : difference;
            if( difference != 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String pali = "Rats live on no evil star";
        String pali2 = "Zeus was deified saw Suez";
        System.out.println("'" + pali + "' is Palindorme : " +isPalindrome(pali));
        System.out.println("'" + pali2 + "' is Palindorme : " +isPalindrome(pali2));
    }
}
