package Strings;

public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
//iterate though, and check last char
        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < word2.length(); j++) {
                char c2 = word2.charAt(j);
//if last two chars equal
                if (c1 == c2) {
//update dp value for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;
                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i + 1][j + 1] = min;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
    public static void main(String[] args) {
        System.out.println(minDistance("abc","def"));
        
    }
}
