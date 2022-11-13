package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SudokuBoxTest {

    @Test
    public void testVerifySudokuBox() {
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        sudokuBoard.solveGame();
        assertEquals(true, sudokuBoard.isBoardValid());

        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                SudokuBox sudokuBox = sudokuBoard.getBox(i, j);
                assertEquals(true, sudokuBox.verify());
            }
        }
        int tmp = sudokuBoard.getFieldValue(0, 1);
        sudokuBoard.setFieldValue(0, 0, tmp);
        SudokuBox sudokuBox = sudokuBoard.getBox(0, 0);
        assertEquals(false, sudokuBox.verify());
    }
}