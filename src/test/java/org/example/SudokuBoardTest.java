package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    @Test
    public void testFillBoard(){
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        sudokuBoard.solveGame();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(true, sudokuBoard.isNumberValid(i, j, sudokuBoard.getFieldValue(i, j)));
            }
        }
        //assertEquals(true, sudokuBoard.isBoardValid());
    }

    @Test
    public void testIsBoardsNotTheSame(){
        SudokuBoard sudokuBoard1 = new SudokuBoard(new BacktrackingSudokuSolver());
        SudokuBoard sudokuBoard2 = new SudokuBoard(new BacktrackingSudokuSolver());

        sudokuBoard1.solveGame();
        sudokuBoard2.solveGame();

        //assertEquals(true, sudokuBoard1.isBoardValid());
        //assertEquals(true, sudokuBoard2.isBoardValid());

        assertNotEquals(sudokuBoard1.getBoardByText(), sudokuBoard2.getBoardByText());
    }


}