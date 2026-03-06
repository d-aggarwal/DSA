class Solution {
    class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int total =0;
        

        for (int i =0;i<n;i++) {
            for(int j =0;j<m;j++) {
                if(grid[i][j]==2) q.add(new Pair(i,j));
                if(grid[i][j]==0) total++;
               
            }
        }

        if(total == n*m) return 0;

        int c  = 0;
        

        while(!q.isEmpty()) {
            int size = q.size();
            total+=size;
            while(size >0) {
                Pair p = q.poll();
                int i = p.i;
                int j = p.j;

                if(i-1 >=0 && grid[i-1][j]==1) {
                    grid[i-1][j] = 2;
                    q.add(new Pair(i-1,j));
                }
                if(j-1 >=0 && grid[i][j-1]==1) {
                    grid[i][j-1] = 2;
                    q.add(new Pair(i,j-1));
                }
                if(i+1 <n && grid[i+1][j]==1) {
                    grid[i+1][j] = 2;
                    q.add(new Pair(i+1,j));
                }
                if(j+1 <m && grid[i][j+1]==1) {
                    grid[i][j+1] = 2;
                    q.add(new Pair(i,j+1));
                }
                size--;
            }
            c++;
        }
        System.out.println(total);

        if(total == n*m) return c-1;
        else return -1;
    }
}