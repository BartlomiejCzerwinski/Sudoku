package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static java.lang.System.exit;

public class SudokuBoard {

    private static int BOARD_SIZE = 9;
    private static List<Integer> NUMBERS_TO_MIX = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    private int board[][] = new int [9][9];

    public void fillBoard()
    {
        fillFirstRow();
        fillTheRestOfTheBoard();

    }

    public boolean fillTheRestOfTheBoard()
    {
        for(int i = 1; i < BOARD_SIZE; i++)
        {
            for(int j = 0; j < BOARD_SIZE; j++)
            {
                if(board[i][j] == 0) {
                    for (int numberToInsert = 1; numberToInsert <= BOARD_SIZE; numberToInsert++) {
                        if (isNumberValid(i, j, numberToInsert)) {
                            board[i][j] = numberToInsert;

                            if (fillTheRestOfTheBoard()) {
                                return true;
                            }
                            else{
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void fillFirstRow()
    {
        List<Integer> arrayToFillFirstRow = shuffleNumbers();
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            board[0][i] = arrayToFillFirstRow.get(i);
        }
    }

    public boolean isNumberValid(int rowIndex, int columnIndex, int numberToInsert)
    {
        if(isColumnValid(rowIndex, columnIndex, numberToInsert)){
            if(isRowValid(rowIndex, columnIndex, numberToInsert)){
                if(isBoxValid(rowIndex, columnIndex, numberToInsert)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isColumnValid(int rowIndex, int columnIndex, int numberToInsert)
    {
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            if(board[i][columnIndex] == numberToInsert){
                return false;
            }
        }
        return true;
    }

    public boolean isRowValid(int rowIndex, int columnIndex, int numberToInsert)
    {
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            if(board[rowIndex][i] == numberToInsert){
                return false;
            }
        }
        return true;
    }

    public boolean isBoxValid(int rowIndex, int columnIndex, int numberToInsert)
    {
       int localBoxRowIndex = (rowIndex - (rowIndex % 3));
       int localBoxColumnIndex = (columnIndex - (columnIndex % 3));
        System.out.println(localBoxRowIndex);
        System.out.println(localBoxColumnIndex);
       for(int i = localBoxRowIndex; i < localBoxRowIndex + 3; i++){
           for(int j = localBoxColumnIndex; j < localBoxColumnIndex + 3; j++){
               System.out.println(board[i][j]);
               if(board[i][j] == numberToInsert){
                   System.out.println("number to insert:" + numberToInsert);
                   return false;
               }
           }
       }
        return true;
    }

    public List shuffleNumbers()
    {
        List tmpList = new LinkedList(NUMBERS_TO_MIX);
        List arrayToFillBoard = new LinkedList();
        Random rand = new Random();

        for(int i = 0; i < BOARD_SIZE; i++)
        {
            int indexToTake = rand.nextInt(tmpList.size());
            arrayToFillBoard.add(tmpList.get(indexToTake));
            tmpList.remove(indexToTake);
        }
        return arrayToFillBoard;
    }

    public void printBoard()
    {
        for(int row = 0; row < BOARD_SIZE; row++)
        {
            for(int column = 0; column < BOARD_SIZE; column++)
            {
                System.out.print(board[row][column] + "  ");
            }
            System.out.println();
            System.out.println();
        }
    }
}
