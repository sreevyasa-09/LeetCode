class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, temp = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
                temp = Math.max(temp, count);
            }else{
                count = 0;
                continue;
            }
        }
        return temp;
    }
}