package org.example;

import static org.example.SudokuBoard.BOARD_SIZE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BacktrackingSudokuSolver implements SudokuSolver {
    private static List<Integer> NUMBERS_TO_MIX =
            new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    @Override
    public void solve(SudokuBoard board) {
        fillFirstRow(board);
        fillTheRestOfTheBoard(board);
    }

    public boolean fillTheRestOfTheBoard(SudokuBoard board) {
        for (int row = 1; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {

                if (board.getFieldValue(row, column) == 0) {

                    for (int numberToInsert = 1; numberToInsert <= BOARD_SIZE; numberToInsert++) {

                        if (board.isNumberValid(row, column, numberToInsert)) {
                            int valueToInsert = numberToInsert;
                            board.setFieldValue(row, column, valueToInsert);
                            if (fillTheRestOfTheBoard(board)) {
                                return true;
                            } else {
                                board.setFieldValue(row, column, 0);
                            }
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void fillFirstRow(SudokuBoard board) {
        List<Integer> arrayToFillFirstRow = shuffleNumbers();
        for (int i = 0; i < BOARD_SIZE; i++) {
            int valueToInsert = arrayToFillFirstRow.get(i);
            board.setFieldValue(0, i, valueToInsert);
        }
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
}
