class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int a[][] = new int[n][m];
        long pre = 1, suf = 1, mod = 12345;
        for(int i = 0; i < n; i++){
            if(i <= n-i-1){
                Arrays.fill(a[i], 1);
                Arrays.fill(a[n-i-1], 1);
            }
            for(int j = 0; j < m; j++){
                a[i][j] = (int)(pre * a[i][j] % mod);
                a[n-i-1][m-j-1] = (int)(suf*a[n-i-1][m-j-1]%mod);
                pre = pre*grid[i][j]%mod;
                suf = suf * grid[n-i-1][m-j-1] % mod;
            }
        }
        return a;
    }
}