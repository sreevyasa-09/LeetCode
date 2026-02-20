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
        if(digitsum > elementsum){
            digitsum -= elementsum;
        }else{
            digitsum = elementsum - digitsum;
        }
        return digitsum;
    }
}