class Solution {
    public static int climb (int []dp, int n, int i) {

   if( i ==0) return 0; 
  if( i ==1) return 1;
if(dp[i]!=-1) return dp[i];
    int one = climb(dp,n,i-1);
    int sec = climb(dp,n,i-2);

    return dp[i] = one+sec;
    }

    public int climbStairs(int n) {
    // int [] dp = new int [n+1];
    // Arrays.fill(dp,-1);
    return climb2(n);
  
    }

    public static int climb2 (int n ) {
        int[]dp = new int[n+1];
        dp[0] = dp[1] =1;
        for(int i =2;i<=n;i++) {
int one = dp[i-1];
    int sec = dp[i-2];

    dp[i] = one+sec;
        }
        return dp[n];
    }
}