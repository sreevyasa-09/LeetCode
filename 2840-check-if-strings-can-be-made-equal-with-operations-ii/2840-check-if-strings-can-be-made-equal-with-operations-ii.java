class Solution {
    public boolean checkStrings(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for(int i = 0; i < s1.length(); i++){
            if(i%2 == 0){
                c1[s1.charAt(i) - 'a']++;
                c1[s2.charAt(i) - 'a']--;
            }else{
                c2[s1.charAt(i) - 'a']++;
                c2[s2.charAt(i) - 'a']--;
            }
        }
        for(int i = 0; i < 26; i++){
            if(c1[i] != 0 || c2[i] != 0) return false;
        }
        return true;
    }
}