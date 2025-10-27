class Solution {
    public int numberOfBeams(String[] bank) {
        
        int curr =0;
        int prev  =0;
        int ans = 0;

        for (int i =0; i<bank.length; i++) {

            String s = bank[i];
            int n = s.length();
            curr =0;
            for (int j =0; j<n; j++) {
                char c = s.charAt(j);
                if(c == '1') curr++;
            }
            ans+=(curr*prev);
            if(curr!=0)prev = curr;
        }
        return ans;
    }
}