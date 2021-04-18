package strings;

import java.util.HashSet;
import java.util.Set;

public class WordBreakDict {

    public static boolean wordBreakHelper(String s, Set<String> dict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (String a : dict) {
            int len = a.length();
            int end = start + len;
            if (end > s.length()) {
                continue;
            }
            if (s.substring(start, start + len).equals(a)) {
                if (wordBreakHelper(s, dict, start + len)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("goo");
        dict.add("google");
        dict.add("gle");
        System.out.println(wordBreakHelper("googooglegle", dict, 0));
        System.out.println(wordBreakHelper("amazon", dict, 0));
    }
}
