class Solution {
    public boolean canConstruct(String s, int k) {
        int[]count = new int[26];

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            count[ch -'a'] ++;
        }

        int singlecount = 0;

         for (int i=0; i<26; i++) {
            
            if(count[i]%2!=0) singlecount++;
        }

        System.out.println(singlecount);

        if(singlecount > k ) return false;
        if ( k > s.length()) return false;

        return true;
    }
}