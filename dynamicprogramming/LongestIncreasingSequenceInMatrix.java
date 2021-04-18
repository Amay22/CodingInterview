package dynamicprogramming;

import java.util.Arrays;

class LongestIncreasingSequenceInMatrix
{

    // Return the length of LIP in 2D matrix
    static int longestIncreasingSequence(int dp[][], int mat[][], int n,
        int m, int x, int y)
    {
        // If value not calculated yet.
        if (dp[x][y] < 0) {
            int result = 0;

            // If reach bottom left cell, return 1.
            if (x == n - 1 && y == m - 1)
                return dp[x][y] = 1;

            // If reach the corner of the matrix.
            if (x == n - 1 || y == m - 1)
                result = 1;

            // If value greater than below cell.
            if (x + 1 < n && mat[x][y] < mat[x + 1][y])
                result = 1 + longestIncreasingSequence(dp, mat, n, m, x + 1, y);

            // If value greater than left cell.
            if (y + 1 < m && mat[x][y] < mat[x][y + 1])
                result = Math.max(result, 1 + longestIncreasingSequence(dp, mat, n, m, x, y + 1));

            dp[x][y] = result;
        }

        return dp[x][y];
    }

    // Wrapper function
    static int helper(int mat[][], int n, int m)
    {
        int dp[][] = new int[10][10];
        for (int i = 0; i < 10; i++)
            Arrays.fill(dp[i], -1);

        return longestIncreasingSequence(dp, mat, n, m, 0, 0);
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        int mat[][] = {
            { 1, 2, 3, 4 },
            { 2, 2, 3, 4 },
            { 3, 2, 3, 4 },
            { 4, 5, 6, 7 },
        };
        int n = 4, m = 4;
        System.out.println(helper(mat, n, m));
    }
}
