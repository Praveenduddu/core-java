package de.zeroco.threads;

import java.util.Random;

class SudokuSolver implements Runnable {
    private int[][] grid;
    private boolean[][] fixedCells;
    private Random random;

    public SudokuSolver(int[][] grid) {
        this.grid = grid;
        this.fixedCells = new boolean[9][9];
        this.random = new Random();
    }

    public void run() {
        solve(0, 0);
    }

    private boolean solve(int row, int col) {
        if (row == 9) {
            return true;
        }

        if (col == 9) {
            return solve(row + 1, 0);
        }

        if (fixedCells[row][col]) {
            return solve(row, col + 1);
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                grid[row][col] = num;

                if (solve(row, col + 1)) {
                    return true; 
                }

                grid[row][col] = 0; 
            }
        }

        return false;
    }

    private boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == num || grid[i][col] == num) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[startRow + i][startCol + j] == num) {
                    return false; 
                }
            }
        }

        return true;
    }

    public void fixCells(int numFixedCells) {
        int count = 0;
        while (count < numFixedCells) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);

            if (!fixedCells[row][col]) {
                fixedCells[row][col] = true;
                count++;
            }
        }
    }

    public void displayGrid() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class SudokuGame {
    public static void main(String[] args) {
        int[][] grid = new int[9][9];
        SudokuSolver solver = new SudokuSolver(grid);

        Thread solverThread = new Thread(solver);
        solverThread.start();

        try {
            solverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        solver.fixCells(30);
        solver.displayGrid();
    }
}

