class Solution {
    public boolean check(int[] nums) {
        int s = 0;
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i] > nums[(i + 1) % n])
                s += 1;
        }
        if(s > 1){
        return false;
         }else
        return true;
    }
}