public class ValidSudoku_036 {
    // Time: O(9x9), Space: O(9x9)
    public static boolean isValidSudoku(char[][] board) {
        int rowColBox = 0;

        for (int i = 0; i < 9; i++) { // Index of row, column and box
            for (int j = 0; j < 9; j++) {
                // Check ith row
                rowColBox = validateAndAddCell(board[i][j], 0, rowColBox);
                if (rowColBox == -1) {
                    return false;
                }

                // Check ith column
                rowColBox = validateAndAddCell(board[j][i], 1, rowColBox);
                if (rowColBox == -1) {
                    return false;
                }

                // Check ith box
                int boxRow = 3 * (i / 3) + (j / 3);
                int colRow = 3 * (i % 3) + (j % 3);
                rowColBox = validateAndAddCell(board[boxRow][colRow], 2, rowColBox);
                if (rowColBox == -1) {
                    return false;
                }
            }
            rowColBox = 0;
        }

        return true;
    }

    private static int validateAndAddCell(char c, int type, int rowColBox) {
        if (c == '.') {
            return rowColBox;
        }
        if (c < '1' || c > '9') {
            return -1;
        }

        int bitIdx = type * 9 + (c - '1');
        if (((rowColBox >> bitIdx) & 1) == 1) {
            return -1;
        }

        return rowColBox | (1 << bitIdx);
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
        System.out.println(isValidSudoku(b1));

        char[][] b2 = new char[][]{
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(b2));
    }
}
