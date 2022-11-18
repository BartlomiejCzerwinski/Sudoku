/**
 * The GNU General Public License (GPL).
 */

package org.example;

import static org.example.SudokuBoard.BOARD_SIZE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class BacktrackingSudokuSolver implements SudokuSolver {
    private static ArrayList<Integer> NUMBERS_TO_MIX =
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));


    @Override
    public void solve(SudokuBoard board) {
        fillFirstRow(board);
        fillTheRestOfTheBoard(board);
    }

    public boolean fillTheRestOfTheBoard(SudokuBoard board) {
        // źródło: https://www.youtube.com/watch?v=mcXc8Mva2bA&t=916s
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
        Collections.shuffle(NUMBERS_TO_MIX);
        for (int i = 0; i < BOARD_SIZE; i++) {
            int valueToInsert = NUMBERS_TO_MIX.get(i);
            board.setFieldValue(0, i, valueToInsert);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BacktrackingSudokuSolver that = (BacktrackingSudokuSolver) o;
        return new EqualsBuilder()
                .append(NUMBERS_TO_MIX, that.NUMBERS_TO_MIX)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(9,9)
                .append(NUMBERS_TO_MIX)
                .toHashCode();
    }
}

