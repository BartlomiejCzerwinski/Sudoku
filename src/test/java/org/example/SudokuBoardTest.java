package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    @Test
    public void testFillBoard(){
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.fillBoard();
        assertEquals(true, sudokuBoard.isBoardValid());
    }

    @Test
    public void testIsBoardsNotTheSame(){
        SudokuBoard sudokuBoard1 = new SudokuBoard();
        SudokuBoard sudokuBoard2 = new SudokuBoard();

        sudokuBoard1.fillBoard();
        sudokuBoard2.fillBoard();

        assertEquals(true, sudokuBoard1.isBoardValid());
        assertEquals(true, sudokuBoard2.isBoardValid());

        assertNotEquals(sudokuBoard1.getBoardByText(), sudokuBoard2.getBoardByText());
    }
}