package org.example;

import java.util.Arrays;
import java.util.List;

public class SudokuBoard {
    static int BOARD_SIZE = 9;
    private List<SudokuField> board = Arrays.asList(new SudokuField[81]);

    private SudokuSolver sudokuSolver;

    public SudokuBoard(SudokuSolver sudokuSolver) {
        for (int i = 0; i < BOARD_SIZE * BOARD_SIZE; i++) {
            board.set(i, new SudokuField(0));
        }
        this.sudokuSolver = sudokuSolver;

    }

    public static void main(String[] args) {
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        sudokuBoard.solveGame();
        sudokuBoard.printBoard();
    }

    public SudokuRow getRow(int y) {
        SudokuRow sudokuRow = new SudokuRow();

        for (int columnIndex = 0; columnIndex < BOARD_SIZE; columnIndex++) {
            sudokuRow.setSudokuAreaField(columnIndex,
                    getFieldValue(y, columnIndex));
        }
        return sudokuRow;
    }

    public SudokuColumn getColumn(int x) {
        SudokuColumn sudokuColumn = new SudokuColumn();

        for (int rowIndex = 0; rowIndex < BOARD_SIZE; rowIndex++) {
            sudokuColumn.setSudokuAreaField(rowIndex,
                    getFieldValue(rowIndex, x));
        }
        return sudokuColumn;
    }

    public SudokuBox getBox(int x, int y) {
        SudokuBox sudokuBox = new SudokuBox();
        int localBoxRowIndex = (x - (x % 3));
        int localBoxColumnIndex = (y - (y % 3));

        for (int row = localBoxRowIndex, i = 0; row < localBoxRowIndex + 3; row++, i++) {
            for (int column = localBoxColumnIndex, j = 0;
                 column < localBoxColumnIndex + 3; column++, j++) {
                int placeToInsertValue = (3 * i) + j;
                sudokuBox.setSudokuAreaField(placeToInsertValue,
                        getFieldValue(row, column));
            }
        }
        return sudokuBox;
    }

    public void solveGame() {
        sudokuSolver.solve(this);
    }

    private boolean isColumnValid(int rowIndex, int columnIndex, int numberToInsert) {
        SudokuColumn sudokuColumn = getColumn(columnIndex);
        sudokuColumn.setSudokuAreaField(rowIndex, numberToInsert);

        if (sudokuColumn.verify()) {
            return true;
        } else {
            return false;
        }

    }

    private boolean isRowValid(int rowIndex, int columnIndex, int numberToInsert) {
        SudokuRow sudokuRow = getRow(rowIndex);
        sudokuRow.setSudokuAreaField(columnIndex, numberToInsert);

        if (sudokuRow.verify()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isBoxValid(int rowIndex, int columnIndex, int numberToInsert) {
        SudokuBox sudokuBox = getBox(rowIndex, columnIndex);
        int boxRowIndex = (rowIndex % 3);
        int boxColumnIndex = (columnIndex  % 3);
        int placeToInsertValue = (3 * boxRowIndex) + boxColumnIndex;
        sudokuBox.setSudokuAreaField(placeToInsertValue, numberToInsert);

        if (sudokuBox.verify()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBoardValid() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {

                int tmp = getFieldValue(row, column);
                setFieldValue(row, column, 0);

                if (!isNumberValid(row, column, tmp)) {
                    return false;
                }
                setFieldValue(row, column, tmp);
            }
        }
        return true;
    }

    public boolean isNumberValid(int rowIndex, int columnIndex, int numberToInsert) {
        if (isColumnValid(rowIndex, columnIndex, numberToInsert)
                && isRowValid(rowIndex, columnIndex, numberToInsert)
                && isBoxValid(rowIndex, columnIndex, numberToInsert)) {
            return true;
        }
        return false;
    }

    public String toString() {
        String output = "";
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                output += getFieldValue(row, column);
            }
        }
        return output;
    }

    public int getFieldValue(int x, int y) {
        int positionInList = (9 * x) + y;
        //int tmp = listOfFields.get(positionInList).getFieldValue();
        int tmp = board.get(positionInList).getFieldValue();
        return tmp;
    }

    public void printBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                System.out.print(getFieldValue(row, column) + "  ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public void setFieldValue(int x, int y, int value) {
        int positionInList = (9 * x) + y;
        //listOfFields.get(positionInList).setFieldValue(value);
        board.get(positionInList).setFieldValue(value);
    }

}