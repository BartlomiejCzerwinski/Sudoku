package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SudokuBoard {
    static int BOARD_SIZE = 9;
    private int[][] board = new int [9][9];

    private SudokuSolver sudokuSolver;

    public SudokuBoard(SudokuSolver sudokuSolver) {
        this.sudokuSolver = sudokuSolver;
    }

    public void solveGame() {
    sudokuSolver.solve(this);
    }

    private boolean isColumnValid(int rowIndex, int columnIndex, int numberToInsert) {
        for (int row = 0; row < rowIndex; row++) {
            if (board[row][columnIndex] == numberToInsert) {
                return false;
            }
        }
        return true;
    }

    private boolean isRowValid(int rowIndex, int columnIndex, int numberToInsert) {
        for (int column = 0; column < columnIndex; column++) {
            if (board[rowIndex][column] == numberToInsert) {
                return false;
            }
        }
        return true;
    }

    private boolean isBoxValid(int rowIndex, int columnIndex, int numberToInsert) {
        int localBoxRowIndex = (rowIndex - (rowIndex % 3));
        int localBoxColumnIndex = (columnIndex - (columnIndex % 3));

        for (int row = localBoxRowIndex; row < localBoxRowIndex + 3; row++) {
            for (int column = localBoxColumnIndex; column < localBoxColumnIndex + 3; column++) {
                if (board[row][column] == numberToInsert) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBoardValid() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {

                int tmp = board[row][column];
                board[row][column] = 0;

                if (!isNumberValid(row, column, tmp)) {
                    return false;
                }
                board[row][column] = tmp;
            }
        }
        return true;
    }

    public void printBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                System.out.print(board[row][column] + "  ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public boolean isNumberValid(int rowIndex, int columnIndex, int numberToInsert) {
        if (isColumnValid(rowIndex, columnIndex, numberToInsert)
                && isRowValid(rowIndex, columnIndex, numberToInsert)
                && isBoxValid(rowIndex, columnIndex, numberToInsert)) {
            return true;
        }
        return false;
    }

    public String getBoardByText() {
        String output = "";
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                output += board[row][column];
            }
        }
        return output;
    }

    public int getFieldValue(int x, int y) {
        int tmp = board[x][y];
        return tmp;
    }

    public void setFieldValue(int x, int y, int value) {
        board[x][y] = value;
    }

}
