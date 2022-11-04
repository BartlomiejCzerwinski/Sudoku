package org.example;

public class SudokuRow {
    private SudokuField[] row = new SudokuField[9];
    public boolean verify() {
        for(int i = 1; i <= 9; i ++) {
            int tmp = 0;
            for (SudokuField element : row) {
                if(element.getFieldValue() == i)
                    tmp++;
            }
            if (tmp > 1)
                return false;
        }
        return true;
    }

    public SudokuRow() {
        for(int i = 0; i < 9; i++)
        this.row[i] = new SudokuField(0);
    }

    public void setRowField(int rowIndex, int value) {
        this.row[rowIndex].setFieldValue(value);
    }
}
