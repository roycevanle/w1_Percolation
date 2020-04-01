/* *****************************************************************************
 *  Name: Royce Le
 *  Date: 12.18.19
 *  Description: Week 1, Percolation Hw
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    // percolation grid size
    private int gridLength;

    // which sites are open
    private int openSites;

    // which sites are connected to which other sites
    private WeightedQuickUnionUF grid;

    // test client (optional)
    public static void main(String[] args) {
    }

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("input cannot be 0 or less");
        }
        gridLength = n;
        grid = new WeightedQuickUnionUF(n);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        // 1st validate the site
        validateIndex(row, col);

        // 2nd, mark the site as open

        // 3rd, perform sequence of weightedQuickUnionUF that links the site in question to its open neighbors
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateIndex(row, col);

        // placeholder
        return true;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateIndex(row, col);

        // placeholder
        return true;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        // finds if the top is connected to the bottom
        return grid.connected(0, gridLength - 1);
    }

    // private method to map from 2d pair to 1d union find object index
    private int xyTo1D(int row, int col) {
        return gridLength * (col - 1) + row;

        // Columnn-major order
        // 1, 4, 7
        // 2, 5, 8
        // 3, 6, 9
        // you have to start at row 0 but when you add the col value, start at 1
        //int array[width * height]
        // int SetElement(int row, int col, int value) { aray[width*rowindex+col] = value; }
    }

    // private method for validating indices
    private void validateIndex(int row, int col) {
        if (row < 1 || col < 1 || row > gridLength || col > gridLength) {
            throw new IllegalArgumentException("row or col is out of bounds");
        }
    }
}
