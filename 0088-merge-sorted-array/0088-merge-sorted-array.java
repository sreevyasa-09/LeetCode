class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length;
        int j = nums2.length;
        if(m == 1 && n == 0) return;
        int k = 0;
        for(int u = m; u < m+n; u++){
            nums1[u] = nums2[k];
            k++;
        }
        Arrays.sort(nums1);
    }
}