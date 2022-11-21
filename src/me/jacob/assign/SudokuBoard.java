package me.jacob.assign;

public class SudokuBoard {

    //the size of each subgrid, following logical rules this means that the entire matrix
    //should be n*n
    private final int n;
    private final int subGrids;
    private final SudokuSquare[][] matrix;

    public SudokuBoard(int n) {
        //set n and subgrids
        this.n = n;
        double sqrt = Math.sqrt(n);
        if(sqrt - Math.floor(sqrt)!=0)
            throw new IllegalArgumentException("n is not a perfect square");

        this.subGrids = (int) sqrt;
        //initialize matrix with empty sudoku squares
        this.matrix = new SudokuSquare[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = new SudokuSquare();
            }
        }
    }

    //gets the square in the selected row,col in the main grid
    public SudokuSquare getSquare(int row, int col) {
        //check for valid square
        if(row < 0 || col < 0 || row > rows() || col > cols())
            throw new IllegalArgumentException();

        //return the square
        return matrix[row][col];
    }

    //This represents the amount of rows, columns and numbers
    //in each subgrid
    public int getN() {
        return n;
    }

    /**
     * Subgrids follow the following pattern
     *
     *  0 1 2 ... n
     *  3 4 5 ... n
     *  .
     *  .
     *  . . . . . row/subGrids * n + col/subGrids
     *
     *  Each subgrid has n numbers and is thus n in size
     *
     *  Returns the subgrid that the selected row and column lies in
     */
    public int getSubGrid(int row, int col) {
        return (row / subGrids) * subGrids + col/subGrids;
    }

    public int rows() {
        return n;
    }

    public int cols() {
        return n;
    }

    public boolean isSolved() {
        boolean[][] colCheck = new boolean[cols()][n];
        boolean[][] gridCheck = new boolean[n][n];
        for(int row=0;row<rows();row++) {
            boolean[] rowCheck = new boolean[n];
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
