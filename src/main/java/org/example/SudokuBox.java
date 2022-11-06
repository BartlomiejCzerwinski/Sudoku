package org.example;

public class SudokuBox {
    private int boxSize = 3;
    private SudokuField[][] box = new SudokuField[3][3];

    public boolean verify() {
        for (int i = 1; i <= 9; i++) {
            int tmp = 0;
            for (int a = 0; a < boxSize; a++) {
                for (int b = 0; b < boxSize; b++) {
                    if (box[a][b].getFieldValue() == i) {
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
        for (int i = 0; i < boxSize; i++) {
            for (int y = 0; y < boxSize; y++) {
                this.box[i][y] = new SudokuField(0);
            }
        }
    }

    public void setBoxField(int rowIndex, int columnIndex, int value) {
        this.box[rowIndex][columnIndex].setFieldValue(value);
    }
}
