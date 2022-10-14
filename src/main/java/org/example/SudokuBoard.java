package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class SudokuBoard {
    public void fillBoard()
    {
        for(int i = 0; i < 9; i++)
        {
            List arrayToFillBoard = shuffleNumbers();
            for(int j = 0; j < 9; j++)
            {
                int valueToInsert = (int) arrayToFillBoard.get(i);
                if(checkIfColumIsRight(i, j, valueToInsert) && checkIfRowIsRight(i, j, valueToInsert)) {
                    board[i][j] = (int) arrayToFillBoard.get(i);
                }
            }
        }
    }

    public boolean checkIfColumIsRight(int rowIndex, int columnIndex, int numberToInsert)
    {
        for(int i = 0; i < columnIndex; i++)
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

    public List shuffleNumbers()
    {
        List tempList = new LinkedList(NUMBERS_TO_MIX);
        List arrayToFillBoard = new LinkedList();
        Random rand = new Random();
        for(int i = 0; i < 9; i++)
        {
            int indexToTake = rand.nextInt(tempList.size());
            arrayToFillBoard.add(tempList.get(indexToTake));
            tempList.remove(indexToTake);
        }
        System.out.println(arrayToFillBoard);
        return arrayToFillBoard;
    }

    public void printBoard()
    {
        for(int i = 0; i < 9; i++)
        {
            String output = "";
            for(int j = 0; j < 9; j++)
            {
                int tmp=board[i][j];
                output+=tmp;
            }
            System.out.println(output);
        }
    }

    private int board[][] = new int [9][9];
    public static List<Integer> NUMBERS_TO_MIX = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
}
