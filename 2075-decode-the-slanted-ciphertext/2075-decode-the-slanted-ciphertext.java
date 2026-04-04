class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n/rows;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < cols; i++){
            int r = 0;
            int c = i;
            while(r < rows && c < cols){
                res.append(encodedText.charAt(r * cols + c));
                r++;
                c++;
            }
        }
        while(res.length() > 0 && res.charAt(res.length() - 1) == ' '){
            res.deleteCharAt(res.length()-1);
        }
        return res.toString();
    }
}