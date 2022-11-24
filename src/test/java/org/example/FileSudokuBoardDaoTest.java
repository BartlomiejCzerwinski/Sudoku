package org.example;

import org.junit.jupiter.api.Test;

import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class FileSudokuBoardDaoTest {

    @Test
    public void writeAndReadTest(){
        SudokuBoardDaoFactory sudokuBoardDaoFactory = new SudokuBoardDaoFactory();
        SudokuBoard sudokuBoard1 = new SudokuBoard(new BacktrackingSudokuSolver());
        sudokuBoard1.solveGame();

        Dao<SudokuBoard> fileSudokuBoardDao;

        fileSudokuBoardDao = sudokuBoardDaoFactory.getFileSudokuBoardDao("save.txt");
        fileSudokuBoardDao.write(sudokuBoard1);
        SudokuBoard sudokuBoard2 = fileSudokuBoardDao.read();
        assertEquals(sudokuBoard1, sudokuBoard2);
    }

    @Test
    public void readExceptionTest(){
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        Dao<SudokuBoard> fileSudokuBoardDao;
        Dao<SudokuField> fileSudokuFieldDao;

        fileSudokuBoardDao = factory.getFileSudokuBoardDao("test.txt");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            fileSudokuBoardDao.read();
        });

        assertEquals(RuntimeException.class, exception.getClass());
    }

    @Test
    public void writeExceptionTest(){
        SudokuBoardDaoFactory sudokuBoardDaoFactory = new SudokuBoardDaoFactory();
        Dao<SudokuBoard> fileSudokuBoardDao;
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());

        fileSudokuBoardDao = sudokuBoardDaoFactory.getFileSudokuBoardDao("<?>***");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            fileSudokuBoardDao.write(sudokuBoard);
        });


    }
}