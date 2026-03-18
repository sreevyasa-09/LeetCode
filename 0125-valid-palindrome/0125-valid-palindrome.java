class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length(), left = 0, right = n - 1;
        if(n == 0) return false;
        while(left < right){
        while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
        while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
        if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
        return false;
        else{
            left++;
            right--;
        }
        }
        return true;
    }
}