class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        long[] rowSum = new long[r];
        long[] colSum = new long[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int x = grid[i][j];
                rowSum[i] += x;
                colSum[j] += x;
            }
        }
        for (int i = 1; i < r; i++) {
            rowSum[i] += rowSum[i - 1];
        }
        for (int j = 1; j < c; j++) {
            colSum[j] += colSum[j - 1];
        }

        long total = rowSum[r - 1];

        for (int i = 0; i < r - 1; i++) {
            if (rowSum[i] == total - rowSum[i]) {
                return true;
            }
        }

        for (int j = 0; j < c - 1; j++) {
            if (colSum[j] == total - colSum[j]) {
                return true;
            }
        }

        return false;
    }
}