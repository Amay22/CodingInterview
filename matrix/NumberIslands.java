package matrix;

public class NumberIslands {

    public static int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    merge(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void merge(int[][] grid, int i, int j) {
//validity checking
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
            return;
        }
//if current cell is water or visited
        if (grid[i][j] != 1) {
            return;
        }
//set visited cell to 2
        grid[i][j] = 2;
//merge all adjacent l and
        merge(grid, i - 1, j);
        merge(grid, i + 1, j);
        merge(grid, i, j - 1);
        merge(grid, i, j + 1);
    }

    public static void main(String[] args) {
        int grid[][] = {{1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1}};
        System.out.println(numIslands(grid));

    }
}
