package org.example;

import static org.example.SudokuBoard.BOARD_SIZE;

public class Main {
    public static void main(String[] args) {
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        sudokuBoard.solveGame();
        sudokuBoard.printBoard();
    }

}