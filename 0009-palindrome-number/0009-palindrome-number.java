class Solution {
    public boolean isPalindrome(int x) {
        int n = x;
        int rev = 0;
        while(x != 0){
            int last = x%10;
            rev = rev * 10 + last;
            x = x/10;
        }
        if(n < 0){
            rev = rev*-1;
            return false;
        }
        if(rev == n) return true;
        else return false;
    }
}