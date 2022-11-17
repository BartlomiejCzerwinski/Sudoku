/**
 * The GNU General Public License (GPL).
 */

package org.example;

public class SudokuField {
    private int value = 0;

    public SudokuField(int value) {
        this.value = value;
    }

    public int getFieldValue() {
        return value;
    }

    public void setFieldValue(int value) {
        this.value = value;
    }
}
