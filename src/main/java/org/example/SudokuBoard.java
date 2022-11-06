package org.example;

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
        SudokuBox sudokuBox = new SudokuBox();
        int localBoxRowIndex = (x - (x % 3));
        int localBoxColumnIndex = (y - (y % 3));

        for (int row = localBoxRowIndex, i = 0; row < localBoxRowIndex + 3; row++, i++) {
            for (int column = localBoxColumnIndex, j = 0;
                 column < localBoxColumnIndex + 3; column++, j++) {
                    sudokuBox.setBoxField(i, j, board[row][column].getFieldValue());
                }
            }
        return sudokuBox;
    }

    public void solveGame() {
        sudokuSolver.solve(this);
    }

    private boolean isColumnValid(int rowIndex, int columnIndex, int numberToInsert) {
        SudokuColumn sudokuColumn = new SudokuColumn();
        sudokuColumn = getColumn(columnIndex);
        sudokuColumn.setColumnField(rowIndex, numberToInsert);

        if (sudokuColumn.verify()) {
            return true;
        } else {
            return false;
        }

    }

    private boolean isRowValid(int rowIndex, int columnIndex, int numberToInsert) {
        SudokuRow sudokuRow = new SudokuRow();
        sudokuRow = getRow(rowIndex);
        sudokuRow.setRowField(columnIndex, numberToInsert);

        if (sudokuRow.verify()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isBoxValid(int rowIndex, int columnIndex, int numberToInsert) {
        SudokuBox sudokuBox = new SudokuBox();
        sudokuBox = getBox(rowIndex, columnIndex);
        int boxRowIndex = (rowIndex % 3);
        int boxColumnIndex = (columnIndex  % 3);
        sudokuBox.setBoxField(boxRowIndex, boxColumnIndex, numberToInsert);

        if (sudokuBox.verify()) {
            return true;
        } else {
            return false;
        }
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
