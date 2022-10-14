package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class SudokuBoard {
    public void fillBoard()
    {
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            List<Integer> arrayToFillBoard = shuffleNumbers();
            for(int j = 0; j < BOARD_SIZE; j++)
            {
                board[i][j] = arrayToFillBoard.get(j);
            }
        }
    }

    public boolean checkIfColumIsRight(int rowIndex, int columnIndex, int numberToInsert)
    {
        for(int i = 0; i < rowIndex; i++)
        {
            if(board[i][columnIndex] == numberToInsert){
                return false;
            }
        }
        return true;
    }

    public boolean checkIfRowIsRight(int rowIndex, int columnIndex, int numberToInsert)
    {
        for(int i = 0; i < columnIndex; i++)
        {
            if(board[rowIndex][i] == numberToInsert){
                return false;
            }
        }
        return true;
    }

    public boolean checkIfSquareIsRight(int rowIndex, int columnIndex, int numberToInsert)
    {
        if(rowIndex-1 >= 0) {
            if(columnIndex-1 >= 0) {
                if (board[rowIndex - 1][columnIndex - 1] == numberToInsert)
                    return false;
            }
        }

        if(rowIndex-1 >= 0) {
            if (board[rowIndex - 1][columnIndex] == numberToInsert)
                return false;
        }

        if(rowIndex+1 < BOARD_SIZE) {
            if(columnIndex+1 < BOARD_SIZE) {
                if (board[rowIndex + 1][columnIndex + 1] == numberToInsert)
                    return false;
            }
        }

        if(columnIndex-1 >= 0) {
            if (board[rowIndex][columnIndex - 1] == numberToInsert)
                return false;
        }

        return true;
    }

    public List shuffleNumbers()
    {
        List tempList = new LinkedList(NUMBERS_TO_MIX);
        List arrayToFillBoard = new LinkedList();
        Random rand = new Random();
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            int indexToTake = rand.nextInt(tempList.size());
            arrayToFillBoard.add(tempList.get(indexToTake));
            tempList.remove(indexToTake);
        }
        return arrayToFillBoard;
    }

    public void printBoard()
    {
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            String tmp ="";
            for(int j = 0; j < BOARD_SIZE; j++)
            {
                int x = board[i][j];
                tmp += x;
                tmp += "  ";
            }
            System.out.println(tmp);
            System.out.println();
        }
    }


    private static int BOARD_SIZE = 9;
    private int board[][] = new int [9][9];
    private static List<Integer> NUMBERS_TO_MIX = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
}
