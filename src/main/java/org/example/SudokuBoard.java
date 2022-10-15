package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static java.lang.System.exit;

public class SudokuBoard {
    public void fillBoard()
    {
        fillFirstRow();
        if(fillTheRestOfTheBoard()){
            System.out.println("SUCCESS!!!");
        }
    }

    public boolean fillTheRestOfTheBoard()
    {
        for(int i = 1; i < BOARD_SIZE; i++)
        {
            for(int j = 0; j < BOARD_SIZE; j++)
            {
                if(board[i][j] == 0) {
                    for (int numberToInsert = 1; numberToInsert <= BOARD_SIZE; numberToInsert++) {
                        if (checkIfNumberCanBeInsert(i, j, numberToInsert)) {
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

    public boolean checkIfNumberCanBeInsert(int rowIndex, int columnIndex, int numberToInsert)
    {
        if(checkIfColumIsRight(rowIndex, columnIndex, numberToInsert)){
            if(checkIfRowIsRight(rowIndex, columnIndex, numberToInsert)){
                if(checkIfBoxIsRight(rowIndex, columnIndex, numberToInsert)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIfColumIsRight(int rowIndex, int columnIndex, int numberToInsert)
    {
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            if(board[i][columnIndex] == numberToInsert){
                return false;
            }
        }
        return true;
    }

    public boolean checkIfRowIsRight(int rowIndex, int columnIndex, int numberToInsert)
    {
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            if(board[rowIndex][i] == numberToInsert){
                return false;
            }
        }
        return true;
    }

    public boolean checkIfBoxIsRight(int rowIndex, int columnIndex, int numberToInsert)
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
