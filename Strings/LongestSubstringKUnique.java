package Strings;

import java.util.HashMap;

public class LongestSubstringKUnique {

    public static String maxSubStringKUniqueChars(String s, int k) {
        //declare a counter
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        String maxSubstring = null;
        for (int i = 0; i < s.length(); i++) {
            //add each char to the counter
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            if (map.size() == k + 1) {
                //get maximum
                int range = i - start;
                if (range > maxLen) {
                    maxLen = range;
                    maxSubstring = s.substring(start, i);
                }
                //move left cursor toward right, so that substring contains only k chars
                char first = s.charAt(start);
                while (map.size() > k) {
                    int count = map.get(first);
                    if (count > 1) {
                        map.put(first, count - 1);
                    } else {
                        map.remove(first);
                    }
                    start++;
                }
            }
        }
        if (map.size() == k && maxLen == 0) {
            return s;
        }
        return maxSubstring;
    }
    public static void main(String[] args) {
        String str = "abcdesfhghg";
        System.out.println(maxSubStringKUniqueChars(str, 3));        
    }
}
