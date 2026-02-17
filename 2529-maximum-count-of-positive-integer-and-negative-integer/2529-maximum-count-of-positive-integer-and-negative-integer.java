class Solution {
    public int maximumCount(int[] nums) {
        int positive =0;
        int negative = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0){
                negative++;
            }
            if(nums[i] > 0){
                positive++;
            }
        }
        if(positive > negative){
                return positive;
            }else{
                return negative;
            }
    }
}