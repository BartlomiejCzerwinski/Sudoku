/**
 * The GNU General Public License (GPL).
 */

package org.example;

import java.util.List;

public class SudokuColumn extends SudokuArea {

    public SudokuColumn(List<SudokuField> fields) {
        super(fields);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<SudokuField> fields = this.getSudokuFieldsArray();
        return new SudokuColumn(fields);
    }
}
