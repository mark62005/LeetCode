import java.util.Arrays;

public class SudokuSolver_037 {
    // Time: O(9x9), Space: O(9x9)
    public static void solveSudoku(char[][] board) {
        solveSudokuHelper(board, 0 , 0);
    }

    public static boolean solveSudokuHelper(char[][] board, int row, int col) {
        // If the col is 9, that means you've filled out a whole row. Start the search on the next row by resetting column and incrementing the row by 1
        if (col == board[0].length) {
            col = 0;
            row += 1;
        }

        // If you've reached 9, that means you didn't run into any errors with your blocks in the previous rows, so you have a valid solution
        if (row == board.length) {
            return true;
        }

        // If this piece already has a value, check the next square
        if (board[row][col] != '.') {
            return solveSudokuHelper(board, row, col+1);
        }

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, row, col, num)) {
                // Set the value of the current square to the valid num
                board[row][col] = num;
                // Run this algo for the next square over
                boolean isSolved = solveSudokuHelper(board, row, col+1);
                // The only way we can trigger a true is if we got to the end, so if it's true that means we have a solved board so you just keep returning
                if (isSolved) {
                    return true;
                }
                // If our board isn't solved, backtrack and try the next number
                else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    public static boolean isValid(char[][] board, int row, int col, char value) {
        for (int i = 0; i < board.length; i++) {
            // Check the row and column for duplicates
            if (board[i][col] == value || board[row][i] == value) {
                return false;
            }
        }

        // This generates our "box", for [1, 1] for example, this pair will be the box bound by [0, 2] and [0,2]
        int boxRow = row / 3;
        int boxCol = col / 3;
        for (int i = boxRow * 3; i < (boxRow + 1) * 3; i++) {
            for (int j = boxCol * 3; j < (boxCol + 1) * 3; j++) {
                // Check the box for duplicates
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] b1 = new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(b1);
        System.out.println(Arrays.deepToString(b1));
    }
}
