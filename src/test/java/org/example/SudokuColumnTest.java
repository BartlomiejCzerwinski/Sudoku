/**
 * The GNU General Public License (GPL).
 */

package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SudokuColumnTest {
    @Test
    public void testVerifySudokuColumn() {
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        sudokuBoard.solveGame();
        assertEquals(true, sudokuBoard.isBoardValid());

        for (int i = 0; i < 9; i++) {
            SudokuColumn sudokuColumn = sudokuBoard.getColumn(i);
            assertEquals(true, sudokuColumn.verify());
        }
        int tmp = sudokuBoard.getFieldValue(0, 0);
        sudokuBoard.setFieldValue(1, 0, tmp);
        SudokuColumn sudokuColumn = sudokuBoard.getColumn(0);
        assertEquals(false, sudokuColumn.verify());
    }
}