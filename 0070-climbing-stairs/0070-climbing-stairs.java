class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int slast = 1;
        int last = 2;
        int cur = 0;
        for(int i = 3; i <= n; i++){
            cur = last + slast;
            slast = last;
            last = cur;
        }
         return cur;
    }
}