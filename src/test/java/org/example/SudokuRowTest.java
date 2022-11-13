package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SudokuRowTest {
    @Test
    public void testVerifySudokuRow() {
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        sudokuBoard.solveGame();
        assertEquals(true, sudokuBoard.isBoardValid());

        for (int i = 0; i < 9; i++) {
            SudokuRow sudokuRow = sudokuBoard.getRow(i);
            assertEquals(true, sudokuRow.verify());
        }
        int tmp = sudokuBoard.getFieldValue(0, 0);
        sudokuBoard.setFieldValue(0, 1, tmp);
        SudokuRow sudokuRow = sudokuBoard.getRow(0);
        assertEquals(false, sudokuRow.verify());
    }
}