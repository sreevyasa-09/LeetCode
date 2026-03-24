class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int left = 0, right = n-1; 
        int max = 0;
        while(left < right){
            int area = Math.min(arr[left], arr[right])*(right - left);
            max = Math.max(max, area);
            if(arr[left] < arr[right]) left++;
            else right--;
        }
        return max;
    }
}