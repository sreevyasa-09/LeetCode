import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        // litter[i][j] = bit number of litter at this cell
        int[][] litter = new int[m][n];

        int sr = 0, sc = 0;
        int count = 0;

        // Find S and number each L
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } 
                else if (ch == 'L') {
                    litter[i][j] = count++;
                }
            }
        }

        // No litter
        if (count == 0)
            return 0;

        int totalMask = (1 << count) - 1;

        /*
         * State:
         * [row, col, energy, mask]
         */
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << count];

        Queue<int[]> q = new LinkedList<>();

        // Start with full energy and no litter collected
        q.offer(new int[]{sr, sc, energy, 0});

        visited[sr][sc][energy][0] = true;

        int moves = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int size = q.size();

            // Process one BFS level
            while (size-- > 0) {

                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];
                int e = cur[2];
                int mask = cur[3];

                // All litter collected
                if (mask == totalMask)
                    return moves;

                // No energy -> cannot move
                if (e == 0)
                    continue;

                for (int k = 0; k < 4; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    // Outside grid
                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n)
                        continue;

                    // Obstacle
                    if (classroom[nr].charAt(nc) == 'X')
                        continue;

                    // Moving costs 1 energy
                    int newEnergy = e - 1;

                    // Reset energy at R
                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = energy;
                    }

                    // Update litter mask
                    int newMask = mask;

                    if (classroom[nr].charAt(nc) == 'L') {
                        int bit = litter[nr][nc];
                        newMask |= (1 << bit);
                    }

                    // Avoid duplicate states
                    if (!visited[nr][nc][newEnergy][newMask]) {

                        visited[nr][nc][newEnergy][newMask] = true;

                        q.offer(new int[]{
                            nr, nc, newEnergy, newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}