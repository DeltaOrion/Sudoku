package me.jacob.assign;

public class SudokuSquare {

    //value of the square
    private int value;
    //whether this is a starting square, i.e. it can't be changed throughout the game
    private boolean startSquare;

    public SudokuSquare(int value, boolean startSquare) {
        this.value = value;
        this.startSquare = startSquare;
    }

    public SudokuSquare(int value) {
        this.value = value;
        this.startSquare = true;
    }

    public SudokuSquare() {
        this.value = 0;
        this.startSquare = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isStartSquare() {
        return startSquare;
    }

    public void setStartSquare(boolean startSquare) {
        this.startSquare = startSquare;
    }
}
