package com.company;

public class Sudoku {

    private int[][] board;
    public static final int empty = 0;
    public static final int size = 9;

    public Sudoku(int[][] board) {
        this.board = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    private boolean isInRow(int row, int number) {
        for(int i = 0; i < size; i++) {
            if(board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isInCol(int col, int number) {
        for(int i = 0; i < size; i++) {
            if(board[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j] == number)
                    return true;

        return false;
    }

    private boolean isOk(int row, int col, int number) {
        return !isInRow(row, number)  &&  !isInCol(col, number)  &&  !isInBox(row, col, number);
    }

    public boolean solve() {
        for(int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(board[row][col] == empty) {
                    for(int number = 1; number <= size; number++) {
                        if(isOk(row, col, number)) {
                            board[row][col] = number;

                            if(solve()) {
                                return true;
                            } else {
                                board[row][col] = empty;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void play() {
        for(int i =0; i < size; i++) {
            for(int j= 0; j < size; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}
