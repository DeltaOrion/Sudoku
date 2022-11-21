package me.jacob.assign;

public class SudokuBoard {

    //the size of each subgrid, following logical rules this means that the entire matrix
    //should be n*n
    private final int n;
    private final SudokuSquare[][] matrix;

    public SudokuBoard(int n) {
        this.n = n;
        //initialize matrix with empty sudoku squares
        this.matrix = new SudokuSquare[n * n][n * n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = new SudokuSquare();
            }
        }
    }

    public SudokuSquare getSquare(int row, int col) {
        //check for valid square
        if(row < 0 || col < 0 || row > rows() || col > cols())
            throw new IllegalArgumentException();

        //return the square
        return matrix[row][col];
    }

    public int getN() {
        return n;
    }

    /**
     * Grids follow the following patter
     *
     *  0 1 2 ... n
     *  3 4 5 ... n
     *
     *  Each grid has n numbers and is n*n in size
     */
    public int getSubGrid(int row, int col) {
        return (row / n) * n + col/n;
    }

    private int boardSize() {
        return n*n;
    }

    public int rows() {
        return boardSize();
    }

    public int cols() {
        return boardSize();
    }

    public boolean isSolved() {
        boolean[][] colCheck = new boolean[cols()][boardSize()];
        boolean[][] gridCheck = new boolean[boardSize()][boardSize()];
        for(int row=0;row<rows();row++) {
            boolean[] rowCheck = new boolean[boardSize()];
            for(int col=0;col<cols();col++) {
                SudokuSquare square = getSquare(row,col);
                if(square.getValue()==0)
                    return false;

                if (rowCheck[square.getValue()-1])
                    return false;

                rowCheck[square.getValue()-1] = true;
                if(colCheck[col][square.getValue()-1])
                    return false;

                colCheck[col][square.getValue()-1] = true;
                int grid = getSubGrid(row,col);
                if(gridCheck[grid][square.getValue()-1])
                    return false;

                gridCheck[grid][square.getValue()-1] = true;
            }
        }
        return true;
    }


}
