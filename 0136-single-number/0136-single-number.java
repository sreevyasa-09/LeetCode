class Solution {
    public int singleNumber(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        if(nums.length == 0) return nums[0];
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            int count = 1;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] == nums[i]){
                visited[j] = true;
                count++;
                }
            }
            if(count == 1)
            return nums[i];
        }
        return -1;
    }
}