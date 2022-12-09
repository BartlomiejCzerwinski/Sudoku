package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardCloneFactoryTest {

    @Test
    public void getCloneTest() throws CloneNotSupportedException {
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        SudokuBoardCloneFactory cloneFactory = new SudokuBoardCloneFactory();

        sudokuBoard.solveGame();

        SudokuBoard copiedBoard = cloneFactory.getClone(sudokuBoard);

        assertTrue(sudokuBoard.equals(copiedBoard));

        int tmp = sudokuBoard.getFieldValue(0,0);
        tmp += 1;
        sudokuBoard.setFieldValue(0, 0, tmp);

        assertFalse(sudokuBoard.equals(copiedBoard));

    }

}