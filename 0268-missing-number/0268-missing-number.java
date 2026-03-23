class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int key = 0;
        for(int i = 0; i <= n; i++){
            key = key ^ i;
            if(i < n){
                key = key ^ nums[i];
            }
        }
        return key;
    }
}