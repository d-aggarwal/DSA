class Solution {
    public long find(int[] nums, int[] colors, int i, long[]dp) {
        if(i<0) return 0;

        if(dp[i]!=-1)return dp[i];
        long inc, notinc =0;
        if(i!=0&& colors[i]==colors[i-1]) {
            inc = nums[i] + find(nums, colors, i-2,dp);
        }else {
            inc = nums[i] + find(nums,colors,i-1,dp);
        }

        notinc = find(nums,colors, i-1,dp);

        return dp[i]= Math.max(inc,notinc);
    }


    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        long[]dp= new long[n];
        long inc, notinc =0;

        for(int i =0; i<n;i++) {
             inc = nums[i];
            if(i!=0&& colors[i]==colors[i-1]) {
               
                if(i>=2) inc+=dp[i-2];
            }else {
                inc = nums[i];
                 if(i>=1) inc+=dp[i-1];
             }

            if(i>=1) notinc=dp[i-1];

            dp[i]= Math.max(inc,notinc);
        }
        return dp[n-1];
    }
}