class Solution {
    public int find(int coins[], int curr,int index, int [][]dp) {
        if(curr ==0) return 1;
        if(dp[curr][index] != -1) return dp[curr][index];
        int sum =0;
        
        for (int i =index; i < coins.length; i++) {
            if(coins[i] <= curr) {
                sum+=find(coins, curr-coins[i],i,dp);
            }
        }
        
        return dp[curr][index] = sum;
    }
    public int count(int coins[], int sum) {
        int[][] dp = new int [sum+1][coins.length];
        // code here.
        for(int i =0;i<=sum;i++) {
            Arrays.fill(dp[i],-1);
        }
        return find(coins,sum,0,dp);
    }
}