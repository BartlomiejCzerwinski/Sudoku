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
        List<SudokuField> tmpList = this.getSudokuFieldsArray();
        SudokuBox sudokuBox = new SudokuBox(new ArrayList<SudokuField>(9));

        return super.clone();
    }
}