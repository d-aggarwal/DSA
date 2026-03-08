class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        int n = s.length();
        int i =0;
        int  j =0;
        int max = 0;
        HashMap<Character, Integer> mp = new HashMap<>();

        while(i<n) {
            char ch = s.charAt(i);

            if(mp.containsKey(ch)) {

                while(j<n && j<i) {
                    char c = s.charAt(j);
                    mp.remove(c);
                    j++;
                    if(!mp.containsKey(ch)) break;
                }
            }

            mp.put(ch, 1);
            max = Math.max(max, i-j+1);

            i++;
        }

        return max;
    }
}