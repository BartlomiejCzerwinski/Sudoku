/**
 * The GNU General Public License (GPL).
 */

package org.example;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow extends SudokuArea {

    public SudokuRow(List<SudokuField> fields) {
        super(fields);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<SudokuField> fields = new ArrayList<>();
        for (SudokuField sf : this.getSudokuFieldsArray()) {
            fields.add(new SudokuField(sf.getFieldValue()));
        }
        return new SudokuRow(fields);
    }
}