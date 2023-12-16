/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 *  Write a program to estimate the value of
 *  the percolation threshold via Monte Carlo simulation.
 *  Note that your code must be in the default package;
 *  if you use a package statement, the autograder will reject your submission.
 **************************************************************************** */

public class Percolation {

    /* 注意：最左上边的 site 是 (1, 1) */
    /* 我们令 close, open 的状态分别为 0, 1 */
    /* 特别解释一下 full, 就是指这个 site 是 open，并且和最上层的 open site 相连  */
    private int[][] sites;
    /* n * n grid */
    private int n;
    /* number of open site */
    private int count;
    /* union-find */
    private int[] ids;
    private int[] size;
    /* move direction */
    private int[][] dirc = {
            { 1, 0 },
            { 0, 1 },
            { -1, 0 },
            { 0, -1 }
    };

    /* here we use a clever trick */
    /* emm however, if a site is connect with top sites,  0 =< rooe(node) <= n-1 */

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        sites = new int[n + 1][n + 1];
        // add two trick nodes
        ids = new int[n * n + 2];
        size = new int[n * n + 2];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
            size[i] = 1;
        }
        // top trick node is root of all top sites
        for (int i = 0; i < n; i++) {
            ids[i] = n * n;
            size[n * n]++;
        }
        count = 0;
    }

    private int turnTwoDimensionsIntoOne(int row, int col) {
        return (row - 1) * n + (col - 1);
    }

    private void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) {
            return;
        }
        if (size[pRoot] < size[qRoot]) {
            ids[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
        else {
            ids[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }

    private boolean check(int row, int col) {
        return row >= 1 && row <= n && col >= 1 && col <= n;
    }

    private int root(int index) {
        while (index != ids[index]) {
            index = ids[index];
        }
        return index;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!check(row, col)) {
            throw new IllegalArgumentException();
        }
        if (!isOpen(row, col)) {
            sites[row][col] = 1;
            int index = turnTwoDimensionsIntoOne(row, col);
            // trick bottom virtual node
            if (row == n) {
                union(index, n * n + 1);
            }
            for (int i = 0; i < dirc.length; i++) {
                if (check(row + dirc[i][0], col + dirc[i][1])
                        && isOpen(row + dirc[i][0], col + dirc[i][1])) {
                    int newIndex = turnTwoDimensionsIntoOne(row + dirc[i][0], col + dirc[i][1]);
                    union(newIndex, index);
                }
            }
            count++;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (!check(row, col)) {
            throw new IllegalArgumentException();
        }
        return sites[row][col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (!check(row, col)) {
            throw new IllegalArgumentException();
        }
        int index = turnTwoDimensionsIntoOne(row, col);
        return isOpen(row, col) && root(index) == root(n * n);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return count;
    }

    // does the system percolate?
    // We say the system percolates if there is a full site in the bottom row
    public boolean percolates() {
        return root(n * n + 1) == root(n * n);
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(3);
        p.open(1, 3);
        p.open(3, 3);
        System.out.println(p.percolates());
        p.open(2, 3);
        System.out.println(p.percolates());
    }
}
