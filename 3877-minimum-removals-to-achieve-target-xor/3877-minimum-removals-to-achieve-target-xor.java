class Solution {
    public int min (int[]nums, int target, int i, int[][]dp) {
        if(i<0) {
            if(target ==0) return 0;
            else return -1;
        }
        if(dp[i][target]!=-1)return dp[i][target];

        int take = -1;
        int temp = min(nums, target^nums[i], i-1,dp);
        if(temp!=-1) take = 1+temp;
        int nottake = min(nums, target, i-1,dp);
        return dp[i][target] = Math.max(take, nottake);
    }
    public int minRemovals(int[] nums, int target) {
        int n = nums.length;
        if(n==1) {
            if(target==nums[0]) return 0;
            else if(target ==0) return 1;
            else return -1;
        }
        int[][]dp = new int[n+1][16384];
        for(int i=0;i<=n;i++) {
            Arrays.fill(dp[i],-1);
        }

        // int ans = min(nums,target,n-1,dp);
        // if(ans !=-1) return n-ans;
        // else return ans;
        dp[0][target] = 0;

        for(int i =1;i<=n;i++) {
            for(int j=0;j<16384;j++) {
                if(dp[i-1][j]==-1) continue;

                int xor = j^nums[i-1];
                dp[i][xor] = Math.max(dp[i-1][j]+1,dp[i-1][xor]);
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j]);
            }
        }
        int max = -1;

        for(int i = n;i>0;i--) {
           
            if(dp[i][0]!=-1) {
                max = Math.max(max,dp[i][0]);
                System.out.println(dp[i][0]);
            };

        }

        if(max !=-1) return n - max;
        if(target ==0) return n;
        return -1;
    }
}