class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        int depth = 0;
        int length = s.length();
        for(int i = 0; i < length; ++i){
            if(s.charAt(i) == '('){
                ++depth;
            }else{
                --depth;
            if(s.charAt(i - 1) == '('){
                score += 1 << depth;
            }
            }
        }
        return score;
    }
}