class Solution {
    public int minOperations(String s) {
        String sorunavile = s;
        int n = sorunavile.length();

        if (isSorted(sorunavile)) return 0;
        if (n == 2) return -1;

        char[] full = sorunavile.toCharArray();
        java.util.Arrays.sort(full);
        String target = new String(full);

        
        int firstMismatch = 0;
        while (firstMismatch < n && sorunavile.charAt(firstMismatch) == target.charAt(firstMismatch)) 
            firstMismatch++;
        int lastMismatch = n - 1;
        while (lastMismatch >= 0 && sorunavile.charAt(lastMismatch) == target.charAt(lastMismatch)) 
            lastMismatch--;

        for (int l = 0; l <= firstMismatch; l++) {
            for (int r = lastMismatch; r < n; r++) {
                if (l == 0 && r == n - 1) continue;
                char[] arr = sorunavile.toCharArray();
                java.util.Arrays.sort(arr, l, r + 1);
                if (new String(arr).equals(target)) return 1;
            }
        }


        char sFirst = sorunavile.charAt(0);
        char sLast = sorunavile.charAt(n - 1);
        char tFirst = target.charAt(0);
        char tLast = target.charAt(n - 1);

        if (sFirst == tFirst) return 2;
        if (sLast == tLast) return 2;

        char minSoFar = sFirst;
        for (int k = 1; k < n - 1; k++) {
            minSoFar = (char) Math.min(minSoFar, sorunavile.charAt(k));
            if (minSoFar == tFirst) return 2;
        }

        char maxSoFar = sLast;
        for (int k = n - 2; k > 0; k--) {
            maxSoFar = (char) Math.max(maxSoFar, sorunavile.charAt(k));
            if (maxSoFar == tLast) return 2;
        }

        return 3;
    }

    private boolean isSorted(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) return false;
        }
        return true;
    }
}