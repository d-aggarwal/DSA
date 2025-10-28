class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        if(s.length()==0) return 0;

        int max = 0;
        int i =0;
        int j =0;
        while (i<s.length()) {
            char c = s.charAt(i);
            mp.put(c, mp.getOrDefault(c,0)+1);
           
            
            while(j<s.length()&& mp.get(c)>1) {
                char cur = s.charAt(j);
                
                mp.put(cur, mp.getOrDefault(cur,0)-1);
                
                j++;
            }

            max = Math.max(max,i-j+1);
            i++;



        }
        
        return max;
    }
}