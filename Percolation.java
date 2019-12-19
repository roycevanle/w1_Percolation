/* *****************************************************************************
 *  Name: Royce Le
 *  Date: 12.18.19
 *  Description: Week 1, Percolation Hw
 **************************************************************************** */

public class Percolation {
    // percolation grid size
        //Not sure, int?
    // which sites are open
        //Array?
    // which sites are connected to which other sites
        //Array?

    // test client (optional)
    public static void main(String[] args) {
    }

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || col < 1) {
            throw new IllegalArgumentException("row or col is out of bounds");
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || col < 1) {
            throw new IllegalArgumentException("row or col is out of bounds");
        }

        // placeholder
        return true;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || col < 1) {
            throw new IllegalArgumentException("row or col is out of bounds");
        }

        // placeholder
        return true;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        //
    }

    // does the system percolate?
    public boolean percolates() {
        //
    }

}
