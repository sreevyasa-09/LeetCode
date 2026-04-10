class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev = cost[0];
        int next = cost[1];
        for(int i = 2; i < n; i++){
            int cur = cost[i] + Math.min(prev, next);
            prev = next;
            next = cur;
        }
        return Math.min(prev, next);
    }
}