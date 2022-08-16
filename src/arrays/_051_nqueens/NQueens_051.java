package arrays._051_nqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens_051 {
    // Time: O(N!), Space: O(N^2)
    public static List<List<String>> solveNQueens(int n) {
        if(n == 0) return new ArrayList<>(); //empty input
        //build grid & fill with dot . -> it will act as empty position
        char[][] grid = new char[n][n];
        for(char[] row : grid) Arrays.fill(row, '.');

        List<List<String>> result = new ArrayList<>();
        int row = 0;
        solve(grid, result, row);
        return result;
    }

    public static void solve(char[][] grid, List<List<String>> result, int row){
        if(row == grid.length){
            List<String> conversion  = convertToString(grid);
            result.add(conversion);
            return;
        }
        for(int col = 0; col < grid.length; col++){
            if(isValidPosition(grid, row, col)){
                grid[row][col] = 'Q';
                solve(grid, result, row + 1);
                grid[row][col] = '.';
            }
        }
    }

    //function to convert character matrix to list of Strings
    public static List<String> convertToString(char[][] grid){
        List<String> result = new ArrayList<>();
        for(char[] row : grid){
            String singleRow = new String(row); //convert char row to string;
            result.add(singleRow);
        }
        return result;
    }

    //function to check current position is valid or not
    public static boolean isValidPosition(char[][] grid, int row, int col){
        //curr row;
        for(int i = row-1; i>= 0; i--){
            if(grid[i][col] == 'Q') return false;
        }
        //left diagonal;
        for(int i = row-1, j = col-1; i >= 0 && j >= 0 ; i--, j--){
            if(grid[i][j] == 'Q') return false;
        }
        //right diagonal;
        for(int i = row-1, j = col+1; i>= 0 && j < grid.length; i--, j++){
            if(grid[i][j] == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
