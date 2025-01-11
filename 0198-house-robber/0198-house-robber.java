class Solution {
    public int rob(int[] nums) {
        int [] dp = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i<nums.length; i++) {
            int exclu = dp[i-1];
            int inclu = nums[i];
            if(i-2 >=0) inclu +=dp[i-2];

            dp[i] = Math.max(inclu,exclu);
        }

        return dp[nums.length -1];
    }
}