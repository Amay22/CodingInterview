package hard;

public class ValidTicTacToe {
    private static boolean validTicTacToe(final char[][] board) {
        // Rule
        // 1. X should be equal or one more than O
        // 2. Only at most one player can win
        // 3. If X win, it must have have one more count than O
        // 4. If O win, it must have the same count with X

        int moves = 0;
        int[] row = new int[3];
        int[] col = new int[3];
        int[] diag = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    moves++;
                    row[i]++;
                    col[j]++;
                    if (i == j) diag[0]++;
                    if (i + j == 2) diag[1]++;
                }
                else if (board[i][j] == 'O') {
                    moves--;
                    row[i]--;
                    col[j]--;
                    if (i == j) diag[0]--;
                    if (i + j == 2) diag[1]--;
                }
            }
        }
        //check number of moves
        if (moves < 0 || moves > 1) return false;
        boolean winX = false, winO = false;
        //note it is possible for one player to meet two winning conditions
        //as the last move is made where two winning conditions met at the same time.
        for (int i = 0; i < 3; i++) {
            if (row[i] == 3 || col[i] == 3 || (i < 2 && diag[i] == 3)) {
                //can not both win
                if (winO) return false;
                winX = true;
            }
            else if (row[i] == -3 || col[i] == -3 || (i < 2 && diag[i] == -3)) {
                //can not both win
                if (winX) return false;
                winO = true;
            }
        }
        //X cannot win with same number of moves
        if (winX && moves == 0) return false;
        //O cannot win with less moves than X
        else if (winO && moves == 1) return false;
        return true;
    }


    public static void main(String[] args) {

        final char[][] test1 =  {
            {'O' , ' ', ' ' },
            {' ' , ' ', ' ' },
            {' ' , ' ', ' ' }
        };

        final char[][] test2 =  {
            {'X' , 'O', 'X' },
            {' ' , 'X', ' ' },
            {' ' , ' ', ' ' }
        };

        final char[][] test3 =  {
            {'X' , 'X', 'X' },
            {' ' , ' ', ' ' },
            {'O' , 'O', 'O' }
        };

        final char[][] test4 =  {
            {'X' , 'O', 'X' },
            {'O' , ' ', 'O' },
            {'X' , 'O', 'X' }
        };

        final char[][] test5 =  {
            {'X' , ' ', 'X' },
            {'O' , 'O', 'O' },
            {'X' , 'X', ' ' }
        };

        System.out.println(validTicTacToe(test1));
        System.out.println(validTicTacToe(test2));
        System.out.println(validTicTacToe(test3));
        System.out.println(validTicTacToe(test4));
        System.out.println(validTicTacToe(test5));
    }
}
