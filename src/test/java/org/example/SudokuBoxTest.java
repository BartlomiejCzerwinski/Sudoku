/**
 * The GNU General Public License (GPL).
 */

package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoxTest {

    @Test
    public void testVerifySudokuBox() {
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        sudokuBoard.solveGame();
        assertEquals(true, sudokuBoard.isBoardValid());

        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                SudokuBox sudokuBox = sudokuBoard.getBox(i, j);
                assertEquals(true, sudokuBox.verify());
            }
        }
        int tmp = sudokuBoard.getFieldValue(0, 1);
        sudokuBoard.setFieldValue(0, 0, tmp);
        SudokuBox sudokuBox = sudokuBoard.getBox(0, 0);
        assertEquals(false, sudokuBox.verify());
    }

    @Test
    public void testHashCode() {
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        sudokuBoard.solveGame();
        assertEquals(true, sudokuBoard.isBoardValid());

         SudokuBox sudokuBox1 = sudokuBoard.getBox(0, 0);
         SudokuBox sudokuBox2 = sudokuBoard.getBox(0, 3);
         SudokuBoard emptySudokuBox = null;
         SudokuRow sudokuRow = sudokuBoard.getRow(0);

         assertEquals(sudokuBox1.hashCode(), sudokuBox1.hashCode());
         assertNotEquals(sudokuBox1.hashCode(), sudokuBox2.hashCode());
         assertEquals(true, sudokuBox1.equals(sudokuBox1));
         assertEquals(false, sudokuBox1.equals(sudokuBox2));
         assertEquals(false, sudokuBox1.equals(emptySudokuBox));
         assertEquals(false, sudokuBox1.equals(sudokuRow));
    }

    @Test
    public void toStringTest() {
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        sudokuBoard.solveGame();
        assertEquals(true, sudokuBoard.isBoardValid());

        SudokuBox sudokuBox = sudokuBoard.getBox(0, 0);

        assertEquals(sudokuBox.toString(), sudokuBox.toString());
    }

    @Test//zrobic deep copy dla sudoku Areas!!!!!!!!!
    public void cloneTest() throws CloneNotSupportedException {
        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        sudokuBoard.solveGame();
        SudokuBox sudokuBox1 = sudokuBoard.getBox(0, 0);
        SudokuBox sudokuBox2 = (SudokuBox) sudokuBox1.clone();

        sudokuBox1.setSudokuAreaField(0, 5);

        assertFalse(sudokuBox1.equals(sudokuBox2));

        assertTrue(sudokuBox1.equals(sudokuBox2));
        sudokuBox1 = sudokuBoard.getBox(8, 8);
        assertFalse(sudokuBox1.equals(sudokuBox2));

        SudokuBox sudokuBox3 = sudokuBoard.getBox(0, 0);

        assertTrue(sudokuBox2.equals(sudokuBox3));


    }
}