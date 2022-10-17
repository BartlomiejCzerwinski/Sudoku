package org.example;

public class Main {
    public static void main(String[] args) {
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.fillBoard();
        sudokuBoard.printBoard();
        int eksperyment = sudokuBoard.getBoard(0,0);
        System.out.println(sudokuBoard.getBoard(0,0)+1);
    }
}