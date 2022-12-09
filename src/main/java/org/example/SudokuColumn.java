/**
 * The GNU General Public License (GPL).
 */

package org.example;

import java.util.ArrayList;
import java.util.List;

public class SudokuColumn extends SudokuArea {

    public SudokuColumn(List<SudokuField> fields) {
        super(fields);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<SudokuField> fields = new ArrayList<>();
        for (SudokuField sf : this.getSudokuFieldsArray()) {
            fields.add(new SudokuField(sf.getFieldValue()));
        }
        return new SudokuColumn(fields);
    }
}
