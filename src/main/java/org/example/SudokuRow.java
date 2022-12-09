/**
 * The GNU General Public License (GPL).
 */

package org.example;

import java.util.List;

public class SudokuRow extends SudokuArea {

    public SudokuRow(List<SudokuField> fields) {
        super(fields);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<SudokuField> fields = this.getSudokuFieldsArray();
        return new SudokuRow(fields);
    }
}