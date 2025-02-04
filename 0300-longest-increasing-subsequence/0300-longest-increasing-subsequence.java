class Solution {
    public static int length(int[] nums, int prev, int i,int[][]dp) {
        if(i== nums.length) return 0;


        if(dp[prev+1][i]!=-1) return dp[prev+1][i];
        int nottake = length(nums, prev, i + 1,dp);

        int take = Integer.MIN_VALUE;

        if (prev == -1 || nums[i] > nums[prev]) {
            take = 1 + length(nums, i, i + 1,dp);
        }

        return dp[prev+1][i] = Math.max(take, nottake);
    }

    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int [nums.length+1][nums.length];

        for(int i =0;i<nums.length+1;i++) {
            Arrays.fill(dp[i],-1);
        }
        return length(nums,-1,0,dp);
    }
}