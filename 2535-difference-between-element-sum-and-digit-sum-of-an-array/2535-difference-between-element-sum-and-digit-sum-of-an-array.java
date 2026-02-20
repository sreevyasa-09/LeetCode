class Solution {
    public int differenceOfSum(int[] nums) {
        int n = nums.length;
        int elementsum = 0;
        int digitsum = 0;

        for(int i = 0; i < n; i++){
            elementsum += nums[i];
            int temp = nums[i];
            while(temp > 0){
                digitsum += temp%10;
                temp /= 10;
            }
        }
        return Math.abs(elementsum-digitsum);
    }
}