package me.jacob.assign;

public class Main {

    public static void main(String[] args) {
        //quick test
        SudokuBoard board = new SudokuBoard(4);
        board.getSquare(0,0).setValue(4);
        board.getSquare(0,1).setValue(1);
        board.getSquare(0,2).setValue(2);
        board.getSquare(0,3).setValue(3);

        board.getSquare(1,0).setValue(2);
        board.getSquare(1,1).setValue(3);
        board.getSquare(1,2).setValue(4);
        board.getSquare(1,3).setValue(1);

        board.getSquare(2,0).setValue(3);
        board.getSquare(2,1).setValue(4);
        board.getSquare(2,2).setValue(1);
        board.getSquare(2,3).setValue(2);

        board.getSquare(3,0).setValue(1);
        board.getSquare(3,1).setValue(2);
        board.getSquare(3,2).setValue(3);
        board.getSquare(3,3).setValue(4);

        System.out.println(board.isSolved());
    }
}
