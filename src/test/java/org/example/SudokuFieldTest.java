package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SudokuFieldTest {
    @Test
    public void testHashCode() {
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        sudokuBoard.solveGame();
        assertEquals(true, sudokuBoard.isBoardValid());

        SudokuField sudokuField1 = new SudokuField(sudokuBoard.getFieldValue(0,0));
        SudokuField sudokuField2 = new SudokuField(sudokuBoard.getFieldValue(0,1));
        SudokuField emptySudokuField = null;
        SudokuColumn sudokuColumn = new SudokuColumn();

        assertEquals(sudokuField1.hashCode(), sudokuField1.hashCode());
        assertNotEquals(sudokuField1.hashCode(), sudokuField2.hashCode());
        assertEquals(true, sudokuField1.equals(sudokuField1));
        assertEquals(false, sudokuField1.equals(sudokuField2));
        assertEquals(false, sudokuField1.equals(emptySudokuField));
        assertEquals(false, sudokuField1.equals(sudokuColumn));
    }

    @Test
    public void toStringTest() {
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        sudokuBoard.solveGame();
        assertEquals(true, sudokuBoard.isBoardValid());

        SudokuField sudokuField = new SudokuField(sudokuBoard.getFieldValue(0,0));

        assertEquals(sudokuField.toString(), sudokuField.toString());
    }
}
