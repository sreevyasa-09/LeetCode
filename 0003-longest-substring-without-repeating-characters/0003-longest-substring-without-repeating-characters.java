class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int maxlen = 0;
        int n = s.length();
        int[] hash = new int[256];
        for(int i = 0; i < 256 ; i++){
            hash[i] = -1;
        }
        while(r < n){
            if(hash[s.charAt(r)] >= l){
                l = Math.max(hash[s.charAt(r)] + 1, l);
            }
            int len = r - l + 1;
            maxlen = Math.max(len, maxlen);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxlen;
    }
}