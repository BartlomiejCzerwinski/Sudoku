package org.example;

public class SudokuColumn {
    private int columnSize = 9;
    private SudokuField[] column = new SudokuField[9];

    public boolean verify() {
        for (int i = 1; i <= 9; i++) {
            int tmp = 0;
            for (int j = 0; j < columnSize; j++) {
                if (column[j].getFieldValue() == i) {
                    tmp++;
                }
            }
            if (tmp > 1) {
                return false;
            }
        }
        return true;
    }

    public SudokuColumn() {
        for (int i = 0; i < columnSize; i++) {
            this.column[i] = new SudokuField(0);
        }
    }

    public void setColumnField(int columnIndex, int value) {
        this.column[columnIndex].setFieldValue(value);
    }
}
