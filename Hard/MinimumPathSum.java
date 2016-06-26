package Hard;

public class MinimumPathSum {

    public static int dfs(int i, int j, int[][] grid) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (i < grid.length - 1 && j < grid[0].length - 1) {
            int r1 = grid[i][j] + dfs(i + 1, j, grid);
            int r2 = grid[i][j] + dfs(i, j + 1, grid);
            return Math.min(r1, r2);
        }
        if (i < grid.length - 1) {
            return grid[i][j] + dfs(i + 1, j, grid);
        }
        if (j < grid[0].length - 1) {
            return grid[i][j] + dfs(i, j + 1, grid);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(dfs(0, 0, matrix));
    }
}
