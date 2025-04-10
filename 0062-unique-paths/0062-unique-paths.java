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

        // for (int i =0;i<m;i++) {
        //     Arrays.fill(dp[i],-1);
        // }
        // return unique(m-1,n-1,dp);

        dp[0][0] = 1;
        for(int i = 0; i<m;i++) {
            for (int j =0;j<n;j++) {
                if(i ==0 && j==0) continue;

                int up = 0;
                int down = 0;
                if(i>0) up = dp[i-1][j] ;
                if(j>0) down = dp[i][j-1];
                dp[i][j] = up+down;
            }
        }

        return dp[m-1][n-1];
    }
}