class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0;
        int temp = 0;
        int[] t = new int[n];
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                count++;
                t[i] = count;
            }else{
                count = 0;
                continue;
            }
        }
        int min = t[0];
        for(int i = 0; i < n; i++){
            if(t[i] > min) min = t[i];
        }
        return min;
    }
}