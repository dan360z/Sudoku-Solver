package com.company;

public class Main {

    public static void main(String[] args) {

        int[][] GRID_TO_SOLVE = {
                {9,0,0,1,0,0,0,0,5},
                {0,0,5,0,9,0,2,0,1},
                {8,0,0,0,4,0,0,0,0},
                {0,0,0,0,8,0,0,0,0},
                {0,0,0,7,0,0,0,0,0},
                {0,0,0,0,2,6,0,0,9},
                {2,0,0,3,0,0,0,0,6},
                {0,0,0,2,0,0,9,0,0},
                {0,0,1,9,0,4,5,7,0},
        };


        Sudoku sudoku = new Sudoku(GRID_TO_SOLVE);
        System.out.println("Sudoku grid to solve");
        sudoku.play();

        if (sudoku.solve()) {
            System.out.println("Sudoku Grid solved");
            sudoku.play();
        } else {
            System.out.println("Unsolvable");
        }

    }
}
