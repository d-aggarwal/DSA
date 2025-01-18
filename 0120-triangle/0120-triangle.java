class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];

        // Initialize the bottom row of dp with the values from the bottom row of the triangle
        
            dp[0][0] = triangle.get(0).get(0);
        

        // Starting from the second to last row, calculate the minimum path sum for each element
        for (int i = 1; i<triangle.size(); i++) {
            for (int j = 0; j <triangle.get(i).size(); j++) {
                // Calculate the two possible paths: moving down or moving diagonally
                int diagonal = (int)Math.pow(10,9);
                int down = (int)Math.pow(10,9);
            
            if(j!=triangle.get(i).size()-1)     down = triangle.get(i).get(j) + dp[i - 1][j];
             if(j>0)    diagonal = triangle.get(i).get(j) + dp[i - 1][j - 1];
            //  else diagonal = (int)Math.pow(10,9)

                // Store the minimum of the two paths in dp
                dp[i][j] = Math.min(down, diagonal);
                System.out.println(dp[i][j] +" "+i+" "+j);
            }
        }

        // The result is stored at the top of dp array
        int m = triangle.get(n-1).size() -1;
        int result =(int)Math.pow(10,9);
        for(int i =0;i<=m;i++) {
            result = Math.min(result,dp[n-1][i]);
        }
        return result;
    }
}