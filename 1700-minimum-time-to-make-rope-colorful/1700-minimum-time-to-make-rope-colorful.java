class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int i =0;
        int len = colors.length();
        int total = 0;
        while(i<len-1) {
            char curr = colors.charAt(i);
           int j = i+1;
            int max =0;
            char next = colors.charAt(j);
            int sum =0;
            max = neededTime[i];
                sum+=neededTime[i];

            while (j<len && curr == next) {
                
                max = Math.max(max,neededTime[j]);
                sum+=neededTime[j];
                j++;
                if(j<len) next = colors.charAt(j);
            }
            total+=(sum-max);
            i = j;

        }
        return total;
    }
}