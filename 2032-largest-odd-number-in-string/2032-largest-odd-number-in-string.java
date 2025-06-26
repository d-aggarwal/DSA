class Solution {
    public String largestOddNumber(String num) {
        String s = "";
        int n = num.length();
        for(int i = n-1;i>=0;i--) {
            char ch = num.charAt(i);
            int nums = (int)(ch - '0');
            if((nums%2)!=0) {
                s = num.substring(0,i+1);
                break;
            }
        }

        return s;
    }
}