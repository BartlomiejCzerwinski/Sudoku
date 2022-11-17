/**
 * The GNU General Public License (GPL).
 */

package org.example;

import org.apache.commons.lang3.builder.ToStringBuilder;

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

    public String toString() {
        return new ToStringBuilder(this)
                .append(value).toString();
    }

}
