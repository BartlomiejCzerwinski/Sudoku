/**
 * The GNU General Public License (GPL).
 */

package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SudokuArea that = (SudokuArea) o;
        return size == that.size && Objects.equals(sudokuFieldsArray, that.sudokuFieldsArray);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, sudokuFieldsArray);
    }

    @Override
    public String toString() {
        String tmp = "";
        for (SudokuField sudokuField : sudokuFieldsArray) {
            tmp += sudokuField.getFieldValue() + " ";
        }
        return tmp;
    }
}