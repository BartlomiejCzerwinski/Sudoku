package org.example;

public class SudokuArea {
    private int size = 9;
    protected SudokuField[] sudokuFieldsArray = new SudokuField[9];

    public SudokuArea() {
        for (int i = 0; i < 9; i++) {
            this.sudokuFieldsArray[i] = new SudokuField(0);
        }
    }

    public boolean verify() {
        for (int i = 1; i <= 9; i++) {
            int tmp = 0;
            for (int j = 0; j < size; j++) {
                if (sudokuFieldsArray[j].getFieldValue() == i) {
                    tmp++;
                }
            }
            if (tmp > 1) {
                return false;
            }
        }
        return true;
    }

    public void setSudokuAreaField(int columnIndex, int value) {

        this.sudokuFieldsArray[columnIndex].setFieldValue(value);
    }
}
