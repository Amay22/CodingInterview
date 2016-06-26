package Strings;

// Question: Isomorphic String:
// Complexity: O(2n) i.e. n is length of string
// Space Complexity is higher for hashmap.
// Two strings are isomorphic if the characters in one can be replaced to get another.
// eg. "egg" and "add" are Isomorphoic
// ALGORITHM:
// Hashmap implementation map every character in 1st string to 2nd
// If there'a  collision and key doesn't match the character then it's not isomorphic.
// And Vice versa i.e.string one becomes and two and two becomes one

import java.util.HashMap;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String one, String two) {
        if (one == null || two == null || one.length() != two.length()  ) {
            return false;
        }
        if (one.length() == 0 && two.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < one.length(); ++i) {
            char c1 = one.charAt(i);
            char c2 = two.charAt(i);
            if(map.containsKey(c1) && c2 != map.get(c1) ){
                return false;
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String one = "egg";
        String two = "add";
        boolean result = isIsomorphic(one, two) && isIsomorphic(two, one);
        System.out.println(result);
    }
}
