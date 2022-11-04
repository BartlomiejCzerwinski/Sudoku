package org.example;

public class SudokuColumn {
    private SudokuField[] column = new SudokuField[9];
    public boolean verify() {
        for(int i = 1; i <= 9; i ++) {
            int tmp = 0;
            for (SudokuField element : column) {
                if(element.getFieldValue() == i)
                    tmp++;
            }
            if (tmp > 1)
                return false;
        }
        return true;
    }

    public SudokuColumn() {
        for(int i = 0; i < 9; i++)
            this.column[i] = new SudokuField(0);
    }

    public void setColumnField(int columnIndex, int value) {
        this.column[columnIndex].setFieldValue(value);
    }
}
