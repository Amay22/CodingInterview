package matrix;

public class SetZeros {

    public static void nullify(int[][] matrix) {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        // Check if first row has a zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        // Check if first column has a zero
        for (int[] matrix1 : matrix) {
            if (matrix1[0] == 0) {
                colHasZero = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[i].length; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < matrix[0].length; ++j) {
            if (matrix[0][j] == 0) {
                System.out.println("j=" + j);
                for (int i = 0; i < matrix.length; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowHasZero) {
            for (int j = 0; j < matrix[0].length; ++j) {
                matrix[0][j] = 0;
            }
        }
        if (colHasZero) {
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 3}, {4, 5, 6}, {7, 8, 0}};
        nullify(matrix);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
