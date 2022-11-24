package org.example;

public class SudokuBoardDaoFactory {
    public Dao<SudokuBoard> getFileSudokuBoardDao(String filename) {
        return new FileSudokuBoardDao(filename);
    }
}
