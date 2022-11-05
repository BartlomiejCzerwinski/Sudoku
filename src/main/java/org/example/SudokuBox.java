package org.example;

public class SudokuBox {
    private SudokuField[][] box = new SudokuField[3][3];

    public boolean verify() {
        for (int i = 1; i <= 9; i++) {
            int tmp = 0;
            for (SudokuField[] row : box) {
                for (SudokuField element : row) {
                    if (i == element.getFieldValue()) {
                        tmp++;
                    }
                }
            }
            if (tmp > 1) {
                return false;
            }
        }
        return true;
    }

    public SudokuBox() {
        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {
                this.box[i][y] = new SudokuField(0);
            }
        }
    }

    public void setBoxField(int rowIndex, int columnIndex, int value) {
        this.box[rowIndex][columnIndex].setFieldValue(value);
    }
}
