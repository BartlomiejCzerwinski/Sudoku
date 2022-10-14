package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.fillBoard();
        sudokuBoard.printBoard();
    }
}