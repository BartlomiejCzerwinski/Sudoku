package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    @Test
    public void testFillBoard(){
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        sudokuBoard.solveGame();

        assertEquals(true, sudokuBoard.isBoardValid());
        int fieldValue = sudokuBoard.getFieldValue(0,0);
        sudokuBoard.setFieldValue(0, 1, fieldValue);
        assertEquals(false, sudokuBoard.isBoardValid());
    }

    @Test
    public void testIsBoardsNotTheSame(){
        SudokuBoard sudokuBoard1 = new SudokuBoard(new BacktrackingSudokuSolver());
        SudokuBoard sudokuBoard2 = new SudokuBoard(new BacktrackingSudokuSolver());

        sudokuBoard1.solveGame();
        sudokuBoard2.solveGame();

        assertEquals(true, sudokuBoard1.isBoardValid());
        assertEquals(true, sudokuBoard2.isBoardValid());

        assertNotEquals(sudokuBoard1.getBoardByText(), sudokuBoard2.getBoardByText());
    }

}