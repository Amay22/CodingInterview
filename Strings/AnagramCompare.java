package Strings;


import java.util.Arrays;

public class AnagramCompare {

    public static boolean anagram_compare(String one, String two) {
        if (one == null || two == null) {
            return false;
        }
        one = one.replace(" ", "").toLowerCase();
        two = two.replace(" ", "").toLowerCase();
        if (one.length() != two.length()) {
            return false;
        }
        char one_char_array[] = one.toCharArray();
        char two_char_array[] = two.toCharArray();
        Arrays.sort(one_char_array);
        Arrays.sort(two_char_array);
        return Arrays.toString(one_char_array).equalsIgnoreCase(Arrays.toString(two_char_array));
    }
    public static boolean anagram_compare2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}		
		int[] letters = new int[128];
		 
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			letters[c]++;  
		}		  
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			letters[c]--;
		    if (letters[c] < 0) {
		    	return false;
		    }
		}
		  
		return true;
	}

    public static void main(String[] args) {
        String one = "torchwood";
        String two = "doctorwho";
        System.out.println(anagram_compare(one, two));
        System.out.println(anagram_compare2(one, two));
    }

}
