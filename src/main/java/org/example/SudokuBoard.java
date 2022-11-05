package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SudokuBoard {
    static int BOARD_SIZE = 9;
    private SudokuField[][] board = new SudokuField[9][9];

    private SudokuSolver sudokuSolver;

    public SudokuBoard(SudokuSolver sudokuSolver) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new SudokuField(0);
            }
        }
        this.sudokuSolver = sudokuSolver;
    }

    public SudokuRow getRow(int y) {
        SudokuRow sudokuRow = new SudokuRow();
        for (int columnIndex = 0; columnIndex < BOARD_SIZE; columnIndex++) {
            sudokuRow.setRowField(columnIndex, board[y][columnIndex].getFieldValue());
        }
        return sudokuRow;
    }

    public SudokuColumn getColumn(int x) {
        SudokuColumn sudokuColumn = new SudokuColumn();
        for (int rowIndex = 0; rowIndex < BOARD_SIZE; rowIndex++) {
            sudokuColumn.setColumnField(rowIndex, board[rowIndex][x].getFieldValue());
        }
        return sudokuColumn;
    }

    public SudokuBox getBox(int x, int y) {
        int boxRowIndex = (x - (x % 3));
        int boxColumnIndex = (y - (y % 3));
        SudokuBox sudokuBox = new SudokuBox();
        for (int row = boxRowIndex; row < boxRowIndex + 3; row++) {
            for (int column = boxColumnIndex; column < boxColumnIndex + 3; column++) {
                sudokuBox.setBoxField(row, column, board[row][column].getFieldValue());
            }

        }
        return sudokuBox;
    }

    private boolean checkBoard() {
        for(int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {

            }
        }
    }

    public void solveGame() {
        sudokuSolver.solve(this);
    }

    private boolean isColumnValid(int rowIndex, int columnIndex, int numberToInsert) {
        for (int row = 0; row < rowIndex; row++) {
            if (board[row][columnIndex].getFieldValue() == numberToInsert) {
                return false;
            }
        }
        return true;
        
    }

    private boolean isRowValid(int rowIndex, int columnIndex, int numberToInsert) {
        for (int column = 0; column < columnIndex; column++) {
            if (board[rowIndex][column].getFieldValue() == numberToInsert) {
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
                if (board[row][column].getFieldValue() == numberToInsert) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBoardValid() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {

                int tmp = board[row][column].getFieldValue();
                board[row][column].setFieldValue(0);

                if (!isNumberValid(row, column, tmp)) {
                    return false;
                }
                board[row][column].setFieldValue(tmp);
            }
        }
        return true;
    }

    public void printBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                System.out.print(board[row][column].getFieldValue() + "  ");
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
        int tmp = board[x][y].getFieldValue();
        return tmp;
    }

    public void setFieldValue(int x, int y, int value) {
        board[x][y].setFieldValue(value);
    }

}
