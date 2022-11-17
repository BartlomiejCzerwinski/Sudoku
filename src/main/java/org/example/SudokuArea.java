/**
 * The GNU General Public License (GPL).
 */

package org.example;

import java.util.Arrays;
import java.util.List;

public class SudokuArea {
    private int size = 9;
    private List<SudokuField> sudokuFieldsArray = Arrays.asList(new SudokuField[9]);

    public SudokuArea() {
        for (int i = 0; i < 9; i++) {
            this.sudokuFieldsArray.set(i, new SudokuField(0));
        }
    }

    public boolean verify() {
        for (int i = 1; i <= 9; i++) {
            int tmp = 0;
            for (int j = 0; j < size; j++) {
                if (sudokuFieldsArray.get(j).getFieldValue() == i) {
                    tmp++;
                }
            }
            if (tmp > 1) {
                return false;
            }
        }
        return true;
    }

    public void setSudokuAreaField(int positionIndex, int value) {

        this.sudokuFieldsArray.get(positionIndex).setFieldValue(value);
    }
}