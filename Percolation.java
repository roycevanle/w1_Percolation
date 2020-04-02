/* *****************************************************************************
 *  Name: Royce Le
 *  Date: 12.18.19
 *  Description: Week 1, Percolation Hw
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    // percolation grid length & area
    private int gridLength;
    private int gridArea;

    // holder of sites & which sites are open
    private int[] siteHolder;
    private int openSites;

    // which sites are connected to which other sites
    private WeightedQuickUnionUF grid;

    // test client (optional)
    public static void main(String[] args) {
        Percolation xyz = new Percolation(3);
        xyz.open(1,1);
        xyz.open(1,2);
        for(int element: xyz.siteHolder) {
            System.out.println(element);
        }
        System.out.println("This is the output:");
        System.out.println(xyz.grid.connected(xyz.xyTo1D(1,1), xyz.xyTo1D(1,2)));

    }

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("input cannot be 0 or less");
        }

        gridLength = n;
        gridArea = n*n;

        siteHolder = new int[gridArea];
        grid = new WeightedQuickUnionUF(gridArea + 2);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        // 1st validate the site
        validateIndex(row, col);

        // 2nd, mark the site as open
        int openIndex = xyTo1D(row, col);
        siteHolder[openIndex] = 1;
        openSites++; //9 0,1,2,3,4,5,6,7,8,9,10
        if (col == 1 && !grid.connected(openIndex, gridArea)) {
            grid.union(openIndex, gridArea);
        }
        else if (col == gridArea - 1 && !grid.connected(openIndex, gridArea + 1)) {
            grid.union(openIndex, gridArea +1);
        }

        // 3rd, perform sequence of weightedQuickUnionUF that links the site in question to its open neighbors
        // check north neighbor
        if (col - 1 >= 1) {
            int northN = xyTo1D(row, col - 1);
            if (siteHolder[northN] == 1) {
                //union
                grid.union(openIndex, northN);
            }
        }
        // check east neighbor
        if (row + 1 <= gridLength) {
            int eastN = xyTo1D(row + 1, col);
            if (siteHolder[eastN] == 1) {
                //union
                grid.union(openIndex, eastN);
            }
        }
        // check south neighbor
        if (col + 1 <= gridLength) {
            int southN = xyTo1D(row, col + 1);
            if (siteHolder[southN] == 1) {
                //union
                grid.union(openIndex, southN);
            }
        }
        // check west neighbor
        if (row - 1 >= 1) {
            int westN = xyTo1D(row - 1, col);
            if (siteHolder[westN] == 1) {
                //union
                grid.union(openIndex, westN);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateIndex(row, col);
        if (siteHolder[xyTo1D(row, col)] == 1) {
            return true;
        }
        return false;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (!percolates()) {
            return false;
        }
        validateIndex(row, col);
        if (grid.connected(xyTo1D(row, col), gridArea)) {
            return true;
        }
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        // finds if the top is connected to the bottom
        return grid.connected(gridArea, gridArea+1);
    }

    // private method to map from 2d pair to 1d union find object index
    private int xyTo1D(int row, int col) {
        return gridLength * (col - 1) + row - 1;

        // 22 21 32 23 12

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
