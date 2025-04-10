class Solution {


    public static int unique(int i, int j,int[][]dp) {
        if(i<0 || j<0 ) return 0;
        if(i == 0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];

        int up = unique(i-1,j,dp);
        int left = unique(i,j-1,dp);

     
        return dp[i][j] = up + left;
    }

    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];

        for (int i =0;i<m;i++) {
            Arrays.fill(dp[i],-1);
        }
        return unique(m-1,n-1,dp);
    }
}