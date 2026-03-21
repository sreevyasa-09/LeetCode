class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 1 && n == 0) return;
        int k = 0;
        for(int u = m; u < m+n; u++){
            nums1[u] = nums2[k];
            k++;
        }
        sort(nums1);
    }
    public void sort(int[] nums1){
        int n = nums1.length;
    for(int i = 0; i < n; i++){
            int min = i;
            for(int j = i +1; j < n; j++){
                if(nums1[j] < nums1[min])
                min = j;
            }
            int temp = nums1[min];
        nums1[min] = nums1[i];
        nums1[i] = temp;
        }
}
}