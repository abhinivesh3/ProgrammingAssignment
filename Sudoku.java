/*2. Sudoku solving program 
Given an incomplete Sudoku configuration in terms of a 9x9 2-D square matrix (grid[][]), the task is to find a solved Sudoku. 
A sudoku solution must satisfy all the following rules: 
1. Each of the digits 1-9 must occur exactly once in each row.
2. Each of the digits 1-9 must occur exactly once in each column. 
3. Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Zeros in the grid indicate blanks, which are to be filled with some number between 1-9. You cannot replace the element in the cell which is not blank.
Input: 
A 9x9 2-D array that represents a sample Sudoku to be solved. (Blanks to be taken as 0 while getting input)
Output:
A 9x9 2-D array that represents the solved Sudoku
*/

import java.util.*;

class Main {
     // Function to find a solved Sudoku. 
    public static boolean SolveSudoku(int grid[][]){
        int[] emptyCell = findEmptyLocation(grid);
        // All cells filled, solution found
        if (emptyCell == null){
            return true;
        }
        int row = emptyCell[0];
        int col = emptyCell[1];

        for (int num = 1; num <= 9; num++) {
            if (isSafe(grid, row, col, num)) {
                grid[row][col] = num;   
                if (SolveSudoku(grid)){
                    return true;
                }
                grid[row][col] = 0; // Backtrack
            }
        }
        return false; // No solution found
    }

    public static boolean isSafe(int[][] grid, int row, int col, int num) {
        // Check if the number is not already present in the current row
        for (int x = 0; x < 9; x++) {
            if (grid[row][x] == num){
                return false;
            }
        }

        // Check if the number is not already present in the current column
        for (int x = 0; x < 9; x++) {
            if (grid[x][col] == num){
                return false;
            }
        }

        // Check if the number is not already present in the current 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i + startRow][j + startCol] == num){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] findEmptyLocation(int[][] grid) {
        int[] location = new int[2];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    location[0] = i;
                    location[1] = j;
                    return location;
                }
            }
        }
        return null;
    }
    
    //Function to print grids of the Sudoku.
    public static void printGrid (int grid[][])
    {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int grid[][]=new int[9][9];
        // Input for Grid
        System.out.println("Enter value to grid : ");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                grid[i][j]=scanner.nextInt();
            }
        }
        if(SolveSudoku(grid)){
            System.out.println("Sudoku is Solved ");
            printGrid(grid);
        }
        else{
            System.out.println("Sudoku can't be possible to solve");
        }
    }
}
