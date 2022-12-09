/**
 * The GNU General Public License (GPL).
 */

package org.example;

import java.util.ArrayList;
import java.util.List;

public class SudokuBox extends SudokuArea {

    public SudokuBox(List<SudokuField> fields) {
        super(fields);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<SudokuField> fields = this.getSudokuFieldsArray();
        return new SudokuBox(fields);
    }
}