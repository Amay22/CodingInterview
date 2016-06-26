// Coding: Given an input array, print the most frequent character in that array. 
// However, when two or more character with the same frequency, print the one with 
// smaller index. e.g. "HAHAB" -> you should print 'H'.
package Strings;

public class MaxRepeating {

    public static char getMax(String word) {        
        char maxchar = ' ';
        int maxcnt = 0;
        // if you are confident that your input will be only ascii, then this array can be size 128.
        int[] charcnt = new int[Character.MAX_VALUE + 1];
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            // increment this character's cnt and compare it to our max.
            if (++charcnt[ch] >= maxcnt) {
                maxcnt = charcnt[ch];
                maxchar = ch;
            }
        }
        return maxchar;
    }

    public static void main(String[] args) {
        System.out.println(getMax("HAHAB"));
    }
}
