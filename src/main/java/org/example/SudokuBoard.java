package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SudokuBoard {
    private static int BOARD_SIZE = 9;
    private static List<Integer> NUMBERS_TO_MIX =
            new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    private int[][] board = new int [9][9];

    public void fillBoard() {
        fillFirstRow();
        fillTheRestOfTheBoard();
    }

    public boolean fillTheRestOfTheBoard() {
        for (int row = 1; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {

                if (board[row][column] == 0) {

                    for (int numberToInsert = 1; numberToInsert <= BOARD_SIZE; numberToInsert++) {

                        if (isNumberValid(row, column, numberToInsert)) {

                            board[row][column] = numberToInsert;
                            if (fillTheRestOfTheBoard()) {
                                return true;
                            } else {
                                board[row][column] = 0;
                            }
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void fillFirstRow() {
        List<Integer> arrayToFillFirstRow = shuffleNumbers();
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[0][i] = arrayToFillFirstRow.get(i);
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

    public boolean isColumnValid(int rowIndex, int columnIndex, int numberToInsert) {
        for (int row = 0; row < rowIndex; row++) {
            if (board[row][columnIndex] == numberToInsert) {
                return false;
            }
        }
        return true;
    }

    public boolean isRowValid(int rowIndex, int columnIndex, int numberToInsert) {
        for (int column = 0; column < columnIndex; column++) {
            if (board[rowIndex][column] == numberToInsert) {
                return false;
            }
        }
        return true;
    }

    public boolean isBoxValid(int rowIndex, int columnIndex, int numberToInsert) {
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

    public List shuffleNumbers() {
        List tmpList = new LinkedList(NUMBERS_TO_MIX);
        List listToFillFirstRow = new LinkedList();
        Random rand = new Random();

        for (int i = 0; i < BOARD_SIZE; i++) {
            int indexToTake = rand.nextInt(tmpList.size());
            listToFillFirstRow.add(tmpList.get(indexToTake));
            tmpList.remove(indexToTake);
        }
        return listToFillFirstRow;
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

    public String getBoardByText() {
        String output = "";
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                output += board[row][column];
            }
        }
        return output;
    }

    public int getFieldValue(int a, int b) {
        int tmp = board[a][b];
        return tmp;
    }
}
