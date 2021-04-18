package strings;

public class LengthOfLast {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                flag = true;
                result++;
            } else if (flag) {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a h as assahd as   "));
    }
}
